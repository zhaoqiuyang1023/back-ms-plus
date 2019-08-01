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
 * 字典表,测试表
 *
 * @author Alan
 * @date 2019-08-01 10:54:19
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("sys_dict")
public class SysDict extends Model<SysDict> {
private static final long serialVersionUID=1L;


        @TableId(type = IdType.UUID)
    @TableField(value = "id")
@ApiModelProperty(value = "编号")
private Long id;

    @TableField(value = "value")
@ApiModelProperty(value = "数据值")
private String value;

    @TableField(value = "label")
@ApiModelProperty(value = "标签名")
private String label;

    @TableField(value = "type")
@ApiModelProperty(value = "类型")
private String type;

    @TableField(value = "description")
@ApiModelProperty(value = "描述")
private String description;

    @TableField(value = "sort")
@ApiModelProperty(value = "排序（升序）")
private Integer sort;

    @TableField(value = "parent_id")
@ApiModelProperty(value = "父级编号")
private String parentId;

    @TableField(value = "create_by")
@ApiModelProperty(value = "创建者")
private String createBy;

    @TableField(value = "create_date")
@ApiModelProperty(value = "创建时间")
private Date createDate;

    @TableField(value = "update_by")
@ApiModelProperty(value = "更新者")
private String updateBy;

    @TableField(value = "update_date")
@ApiModelProperty(value = "更新时间")
private Date updateDate;

    @TableField(value = "remarks")
@ApiModelProperty(value = "备注信息")
private String remarks;

    @TableField(value = "del_flag")
@ApiModelProperty(value = "删除标记")
private String delFlag;

/**
 * primary key
 */
@Override
protected Serializable pkVal(){
        return this.id;
        }
        }
