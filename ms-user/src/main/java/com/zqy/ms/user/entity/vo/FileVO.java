package com.zqy.ms.user.entity.vo;

import lombok.Data;

/**
 * @author : Alan
 * @date : 2019/9/4  15:53
 */
@Data
public class FileVO {


    private String id;
    private String fileName;
    private String src;
    private String relativePath;
    private String fileType;
    private String fileSize;

    public FileVO() {

    }

    public FileVO(String src,String fileName,String relativePath,  String fileType, String fileSize) {
        this.src = src;
        this.fileName=fileName;
        this.relativePath = relativePath;
        this.fileType = fileType;
        this.fileSize = fileSize;
    }
}
