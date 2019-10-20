package com.zqy.ms.user.entity.ao;

import lombok.Data;

@Data
public class BasePageAO {

    private Integer page = 1;

    private Integer limit = 10;

    private String name;

    private String beginDate;

    private String endDate;
}
