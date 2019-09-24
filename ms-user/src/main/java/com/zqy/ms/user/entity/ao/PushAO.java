package com.zqy.ms.user.entity.ao;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * @author : Alan
 * @date : 2019/8/26  10:10
 */

@Data
public class PushAO {


    @ApiModelProperty(value = "title")
    private String title;

    @ApiModelProperty(value = "msg")
    private String msg;

    @ApiModelProperty(value = "msg")
    private String type;


    @ApiModelProperty(value = "其他的参数最好传json")
    private String extraParam;


    @ApiModelProperty(value = "要推送的设备标识，这里是userId的集合")
    private List<String> alias;
}
