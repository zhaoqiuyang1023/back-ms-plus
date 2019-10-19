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
@TableName("role")
public class Role extends Model<Role> {
private static final long serialVersionUID=1L;


        @TableId(type = IdType.UUID)
            @TableField(value = "id")
@ApiModelProperty(value = "id")
private String id;

            @TableField(value = "name")
@ApiModelProperty(value = "角色名称")
private String name;

                @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @TableField(value = "create_date")
@ApiModelProperty(value = "创建时间")
private Date createDate;

            @TableField(value = "create_by")
@ApiModelProperty(value = "创建人id")
private String createBy;

                @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @TableField(value = "update_date")
@ApiModelProperty(value = "修改时间")
private Date updateDate;

            @TableField(value = "update_by")
@ApiModelProperty(value = "修改人id")
private String updateBy;

            @TableField(value = "remarks")
@ApiModelProperty(value = "备注")
private String remarks;

            @TableField(value = "organization_id")
@ApiModelProperty(value = "公司id")
private String organizationId;

/**
 * primary key
 */
@Override
protected Serializable pkVal(){
        return this.id;
        }
        }
