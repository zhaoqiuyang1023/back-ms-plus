package com.zqy.ms.user.entity.ao;

import lombok.Data;

/**
 * @author : Alan
 * @date : 2019/9/4  17:33
 */

@Data
public class FilePageAO {

    private Integer page = 1;

    private Integer limit = 10;

    private String beginTime;

    private String endTime;
}
