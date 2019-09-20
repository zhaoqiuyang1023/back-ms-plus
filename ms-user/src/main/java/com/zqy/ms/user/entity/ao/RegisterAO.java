package com.zqy.ms.user.entity.ao;

import com.baomidou.mybatisplus.annotation.TableField;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class RegisterAO {

    @ApiModelProperty(value = "用户名")
    private String id;
    @ApiModelProperty(value = "用户名")
    private String username;
    @ApiModelProperty(value = "用户名")
    private String nickName;

    @ApiModelProperty(value = "密码")
    private String password;
    @ApiModelProperty(value = "手机号")
    private String tel;
    @ApiModelProperty(value = "公司名称")
    private String organizationName;

    @ApiModelProperty(value = "公司地址")
    private String address;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @TableField(value = "cut_off_date")
    @ApiModelProperty(value = "到期时间")
    private String cutOffDate;

}
