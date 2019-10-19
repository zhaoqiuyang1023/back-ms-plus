package com.zqy.ms.user.entity;

import com.baomidou.mybatisplus.annotation.*;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;
import lombok.EqualsAndHashCode;
import io.swagger.annotations.ApiModelProperty;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.util.Date;


/**
 * 
 *
 * @author Alan
 * @date 2019-10-18 23:08:59
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("user_role_pk")
public class UserRolePk extends Model<UserRolePk> {
private static final long serialVersionUID=1L;


        @TableId(type = IdType.UUID)
            @TableField(value = "id")
@ApiModelProperty(value = "")
private String id;

            @TableField(value = "user_id")
@ApiModelProperty(value = "用户id")
private String userId;

            @TableField(value = "role_id")
@ApiModelProperty(value = "角色id")
private String roleId;

/**
 * primary key
 */
@Override
protected Serializable pkVal(){
        return this.id;
        }
        }
