package com.zqy.ms.user.controller.file;

import com.zqy.ms.user.entity.SysRescource;
import com.zqy.ms.user.entity.SysUser;
import com.zqy.ms.user.entity.vo.FileVO;
import com.zqy.ms.user.service.SysRescourceService;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Controller;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.UUID;

/**
 * @author : Alan
 * @date : 2019/7/29  16:02
 */

@Controller
@RequestMapping("file")
@Slf4j
public class FileController {


    @Value("${server.port}")
    private String port;

    @Autowired
    private SysRescourceService sysRescourceService;

    @PostMapping("upload")
    @ResponseBody
    public R<FileVO> localUpload(MultipartFile file, HttpServletRequest request) {
        String ip = request.getServerName();
        log.info(ip);
        //jar包的同目录的files文件夹下
        String localUploadPath = System.getProperty("user.dir") + "/files/";
        try {
            File dir = new File(localUploadPath);
            if (!dir.exists()) {
                dir.mkdirs();
            }
            String md5DigestAsHex = DigestUtils.md5DigestAsHex(UUID.randomUUID().toString().getBytes(StandardCharsets.UTF_8.name()));
            String rename = md5DigestAsHex + file.getOriginalFilename();
            String filePath = localUploadPath + rename;
            Subject s = SecurityUtils.getSubject();
            String src = "http://" + ip + ":" + port + "/file/" + rename;
            log.info(src);
            FileVO fileVO = new FileVO(src, file.getName(), "/file/" + rename, file.getContentType(), "" + file.getSize());
            SysUser sysUser = (SysUser) s.getPrincipal();
            SysRescource sysRescource = new SysRescource();
            System.out.println("用户id"+sysUser.getId());
            sysRescource.setCreateBy(sysUser.getId());
            sysRescource.setFileName(rename);
            sysRescource.setOriginalFilename(file.getOriginalFilename());
            sysRescource.setFileType(file.getContentType());
            sysRescource.setSrc(src);
            sysRescource.setRelativePath("/file/" + rename);
            sysRescource.setFileSize(""+file.getSize());
            sysRescourceService.save(sysRescource);
            file.transferTo(new File(filePath));
            return new R<>(fileVO);
        } catch (Exception e) {
            e.printStackTrace();
            return new R<>(e);
        }
    }

    @Async
    @RequestMapping("/{name}")
    public void download(@PathVariable("name") String name, HttpServletResponse response) throws IOException {
        String localUploadPath = System.getProperty("user.dir") + "/files/" + name;
        FileInputStream fileInputStream = new FileInputStream(localUploadPath);
        ByteArrayOutputStream byteStream = new ByteArrayOutputStream();
        byte[] buffer = new byte[1024];
        int ch;
        while ((ch = fileInputStream.read(buffer)) != -1) {
            byteStream.write(buffer, 0, ch);
        }
        byte[] data = byteStream.toByteArray();
        byteStream.close();
        fileInputStream.close();
        response.reset();
        response.setHeader("Content-Disposition", String.format("attachment; filename=%s", name));
        response.addHeader("Content-Length", "" + data.length);
        response.setContentType("application/octet-stream; charset=UTF-8");
        OutputStream outputStream = response.getOutputStream();
        outputStream.write(data);
        outputStream.flush();
        outputStream.close();
    }


}
