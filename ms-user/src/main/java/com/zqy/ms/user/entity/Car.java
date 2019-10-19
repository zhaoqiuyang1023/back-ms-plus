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
 * 汽车
 *
 * @author Alan
 * @date 2019-10-18 23:08:59
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("car")
public class Car extends Model<Car> {
private static final long serialVersionUID=1L;


        @TableId(type = IdType.UUID)
            @TableField(value = "id")
@ApiModelProperty(value = "")
private String id;

            @TableField(value = "car_no")
@ApiModelProperty(value = "车牌号")
private String carNo;

            @TableField(value = "remark")
@ApiModelProperty(value = "")
private String remark;

            @TableField(value = "locked")
@ApiModelProperty(value = "是否启用")
private String locked;

            @TableField(value = "organization_id")
@ApiModelProperty(value = "公司id")
private String organizationId;

            @TableField(value = "user_id")
@ApiModelProperty(value = "用户id司机id")
private String userId;

/**
 * primary key
 */
@Override
protected Serializable pkVal(){
        return this.id;
        }
        }
