package com.zqy.ms.user.controller.file;

import com.zqy.ms.user.entity.vo.FileVO;
import com.zqy.ms.user.util.RestResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
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
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
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


    @Value("${file.upload}")
    private String file_upload;


    @PostMapping("upload")
    @ResponseBody
    public RestResponse localUpload(MultipartFile file, HttpServletRequest request) {
        RestResponse restResponse = new RestResponse();
        log.info(file_upload);

        String ip = request.getServerName();
        String getContextPath = request.getContextPath();
        String basePath = request.getScheme() + "://" + request.getRemoteHost() + ":" + request.getServerPort() + getContextPath + "/";
        log.info(basePath);
        log.info(ip);
        //jar包的同目录的files文件夹下
        String localUploadPath = System.getProperty("user.dir") + "/backfiles/";
        try {
            File dir = new File(localUploadPath);
            if (!dir.exists()) {
                dir.mkdirs();
            }
            String md5DigestAsHex = DigestUtils.md5DigestAsHex(UUID.randomUUID().toString().getBytes(StandardCharsets.UTF_8.name()));
            String rename = md5DigestAsHex + file.getOriginalFilename();
            String filePath = localUploadPath + rename;

            String src = file_upload + "/file/download/" + rename;
            log.info(src);
            FileVO fileVO = new FileVO(src, file.getName(), "/file/download/" + rename, file.getContentType(), "" + file.getSize());

            file.transferTo(new File(filePath));
            restResponse.setData(fileVO);
            return restResponse;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @RequestMapping("/download/{name}")
    public void download(@PathVariable("name") String name, HttpServletResponse response) throws IOException {
        String localUploadPath = System.getProperty("user.dir") + "/backfiles/" + name;
        FileInputStream fileInputStream = new FileInputStream(localUploadPath);
      //  FileChannel fileChannel = fileInputStream.getChannel();
      //  ByteBuffer byteBuffer = ByteBuffer.allocate(fileInputStream.available());
      //  fileChannel.read(byteBuffer);

        ByteArrayOutputStream byteStream = new ByteArrayOutputStream();
        byte[] buffer = new byte[1024];
        int ch;
        while ((ch = fileInputStream.read(buffer)) != -1) {
            byteStream.write(buffer, 0, ch);
        }
        byte[] data = byteStream.toByteArray();
    //    byte[] data = byteBuffer.array();
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
