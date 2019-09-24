package com.zqy.ms.user.entity.ao;

import lombok.Data;

@Data
public class ForbiddenAO {

    private Integer page = 1;

    private Integer limit = 10;

    private String accountName;

    private String userName;

    private String startTime;

    private String endTime;

}
