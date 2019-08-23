package com.zqy.ms.user.entity;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.Date;


/**
 * @author Alan
 * @date 2019-08-01 10:54:19
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("sys_user")
public class SysUser extends Model<SysUser> {
    private static final long serialVersionUID = 1L;


    @TableId(type = IdType.UUID)
    @TableField(value = "id")
    @ApiModelProperty(value = "用户ID")
    private Long id;

    @TableField(value = "login_name")
    @ApiModelProperty(value = "登录名")
    private String loginName;

    @TableField(value = "nick_name")
    @ApiModelProperty(value = "昵称")
    private String nickName;

    @TableField(value = "icon")
    @ApiModelProperty(value = "")
    private String icon;

    @TableField(value = "password")
    @ApiModelProperty(value = "密码")
    private String password;

    @TableField(value = "salt")
    @ApiModelProperty(value = "shiro加密盐")
    private String salt;

    @TableField(value = "tel")
    @ApiModelProperty(value = "手机号码")
    private String tel;

    @TableField(value = "email")
    @ApiModelProperty(value = "邮箱地址")
    private String email;

    @TableField(value = "locked")
    @ApiModelProperty(value = "是否锁定")
    private Boolean locked;

    @TableField(value = "create_date")
    @ApiModelProperty(value = "")
    private Date createDate;

    @TableField(value = "create_by")
    @ApiModelProperty(value = "")
    private Long createBy;

    @TableField(value = "update_date")
    @ApiModelProperty(value = "")
    private Date updateDate;

    @TableField(value = "update_by")
    @ApiModelProperty(value = "")
    private Long updateBy;

    @TableField(value = "remarks")
    @ApiModelProperty(value = "")
    private String remarks;

    @TableField(value = "del_flag")
    @ApiModelProperty(value = "")
    private Boolean delFlag;

    /**
     * primary key
     */
    @Override
    protected Serializable pkVal() {
        return this.id;
    }
}
