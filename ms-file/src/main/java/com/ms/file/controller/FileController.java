package com.ms.file.controller;

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
import java.net.UnknownHostException;
import java.nio.charset.StandardCharsets;
import java.util.UUID;

/**
 * @author : Alan
 * @date : 2019/7/29  16:02
 */
@Controller
@RequestMapping("file")
public class FileController {


    @Value("${server.port}")
    private String port;

    @PostMapping("upload")
    @ResponseBody
    public String localUpload(MultipartFile file, HttpServletRequest request) throws UnknownHostException {
        String ip = request.getServerName();

        System.out.println(ip);
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
            file.transferTo(new File(filePath));
            return "http://" + ip + ":" + port + "/file/" + rename;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }


    @RequestMapping("/{name}")
    public void fun(@PathVariable("name") String name, HttpServletResponse response) throws IOException {
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
