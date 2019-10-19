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
 * @author Alan
 * @date 2019-10-18 23:18:18
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("route")
public class Route extends Model<Route> {
    private static final long serialVersionUID = 1L;


    @TableId(type = IdType.UUID)
    @TableField(value = "id")
    @ApiModelProperty(value = "")
    private String id;

    @TableField(value = "name")
    @ApiModelProperty(value = "名称")
    private String name;

    @TableField(value = "car_no")
    @ApiModelProperty(value = "车牌号")
    private String carNo;

    @TableField(value = "organization_id")
    @ApiModelProperty(value = "公司id")
    private String organizationId;

    /**
     * primary key
     */
    @Override
    protected Serializable pkVal() {
        return this.id;
    }
}
