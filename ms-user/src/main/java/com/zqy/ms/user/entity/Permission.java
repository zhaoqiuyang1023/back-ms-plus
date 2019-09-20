package com.zqy.ms.user.entity;

import com.baomidou.mybatisplus.annotation.*;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;
import lombok.EqualsAndHashCode;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;


/**
 * 
 *
 * @author @Alan
 * @date 2019-09-20 20:49:27
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("permission")
public class Permission extends Model<Permission> {
    private static final long serialVersionUID=1L;

    
    @TableId(type = IdType.UUID)
    @TableField(value = "id")
    @ApiModelProperty(value = "")
    private String id;

    @TableField(value = "name")
    @ApiModelProperty(value = "菜单名称")
    private String name;

    @TableField(value = "sort")
    @ApiModelProperty(value = "排序")
    private Integer sort;

    @TableField(value = "remarks")
    @ApiModelProperty(value = "权限标识")
    private String remarks;

/**
 * primary key
 */
@Override
protected Serializable pkVal(){
        return this.id;
        }
        }
