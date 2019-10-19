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
@TableName("role_permission_pk")
public class RolePermissionPk extends Model<RolePermissionPk> {
private static final long serialVersionUID=1L;


        @TableId(type = IdType.UUID)
            @TableField(value = "id")
@ApiModelProperty(value = "主键id")
private String id;

            @TableField(value = "role_id")
@ApiModelProperty(value = "角色id")
private String roleId;

            @TableField(value = "permission_id")
@ApiModelProperty(value = "权限id")
private String permissionId;

/**
 * primary key
 */
@Override
protected Serializable pkVal(){
        return this.id;
        }
        }
