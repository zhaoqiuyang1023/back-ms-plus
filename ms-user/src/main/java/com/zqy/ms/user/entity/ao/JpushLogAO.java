package com.zqy.ms.user.entity.ao;

import lombok.Data;

/**
 * @author : Alan
 * @date : 2019/8/13  10:03
 */
@Data
public class JpushLogAO {
    private Integer page = 1;

    private Integer limit = 10;

    private String beginTime;

    private String endTime;
}
