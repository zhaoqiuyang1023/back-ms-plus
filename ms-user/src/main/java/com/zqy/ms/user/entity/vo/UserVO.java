package com.zqy.ms.user.entity.vo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.security.SecureRandom;
import java.util.Date;


/**
 * @author @Alan
 * @date 2019-09-21 13:00:03
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("user")
public class UserVO extends Model<UserVO> {
    private static final long serialVersionUID = 1L;


    @TableId(type = IdType.UUID)
    @TableField(value = "id")
    @ApiModelProperty(value = "用户id")
    private String id;

    @TableField(value = "username")
    @ApiModelProperty(value = "用户名登录用不能重复")
    private String username;

    @TableField(value = "nick_name")
    @ApiModelProperty(value = "昵称")
    private String nickName;

    @TableField(value = "salt")
    @ApiModelProperty(value = "盐")
    private String salt;

    @TableField(value = "password")
    @ApiModelProperty(value = "用户密码")
    private String password;

    @TableField(value = "tel")
    @ApiModelProperty(value = "用户手机号")
    private String tel;

    @TableField(value = "head_img")
    @ApiModelProperty(value = "用户头像")
    private String headImg;

    @TableField(value = "points")
    @ApiModelProperty(value = "积分")
    private Double points;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @TableField(value = "create_date")
    @ApiModelProperty(value = "创建时间")
    private Date createDate;

    @TableField(value = "device")
    @ApiModelProperty(value = "设备标识")
    private String device;

    @TableField(value = "organization_id")
    @ApiModelProperty(value = "公司编号")
    private String organizationId;

    @ApiModelProperty(value = "公司名称")
    @TableField(exist = false)
    private String organizationName;

    @TableField(value = "admin")
    @ApiModelProperty(value = "是否是管理员")
    private Boolean admin;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @TableField(value = "update_date")
    @ApiModelProperty(value = "修改时间")
    private Date updateDate;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @TableField(value = "cut_off_date")
    private String cutOffDate;

    @TableField(value = "locked")
    @ApiModelProperty(value = "1是不可用0是可用")
    private Boolean locked;

    /**
     * primary key
     */
    @Override
    protected Serializable pkVal() {
        return this.id;
    }
}
