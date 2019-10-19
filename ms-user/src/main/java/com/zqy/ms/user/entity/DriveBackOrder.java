package com.zqy.ms.user.entity;

import com.baomidou.mybatisplus.annotation.*;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.EqualsAndHashCode;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;
import java.math.BigDecimal;


/**
 * @author Alan
 * @date 2019-10-17 22:18:32
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("drive_back_order")
public class DriveBackOrder extends Model<DriveBackOrder> {
    private static final long serialVersionUID = 1L;


    @TableId(type = IdType.UUID)
    @TableField(value = "id")
    @ApiModelProperty(value = "id")
    private String id;

    @TableField(value = "no")
    @ApiModelProperty(value = "单号")
    private String no;

    @TableField(value = "organization_id")
    @ApiModelProperty(value = "organizationId")
    private String organizationId;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @TableField(value = "create_date")
    @ApiModelProperty(value = "创建时间")
    private Date createDate;

    @TableField(value = "driver_order_id")
    @ApiModelProperty(value = "装车单id")
    private String driverOrderId;

    @TableField(value = "operator_id")
    @ApiModelProperty(value = "提交人id")
    private String operatorId;

    @TableField(value = "operator_name")
    @ApiModelProperty(value = "提交人名字")
    private String operatorName;

    @TableField(value = "box_num")
    @ApiModelProperty(value = "")
    private BigDecimal boxNum;

    @TableField(value = "goods_num")
    @ApiModelProperty(value = "")
    private BigDecimal goodsNum;

    /**
     * primary key
     */
    @Override
    protected Serializable pkVal() {
        return this.id;
    }
}
