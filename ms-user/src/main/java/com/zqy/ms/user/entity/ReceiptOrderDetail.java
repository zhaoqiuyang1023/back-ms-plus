package com.zqy.ms.user.entity;

import com.baomidou.mybatisplus.annotation.*;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;
import lombok.EqualsAndHashCode;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;
import java.math.BigDecimal;


/**
 * 
 *
 * @author Alan
 * @date 2019-10-17 22:18:32
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("receipt_order_detail")
public class ReceiptOrderDetail extends Model<ReceiptOrderDetail> {
private static final long serialVersionUID=1L;


        @TableId(type = IdType.UUID)
            @TableField(value = "id")
@ApiModelProperty(value = "")
private String id;

            @TableField(value = "receipt_order_id")
@ApiModelProperty(value = "收款单id")
private String receiptOrderId;

            @TableField(value = "delivery_order_id")
@ApiModelProperty(value = "配送id")
private String deliveryOrderId;

            @TableField(value = "money")
@ApiModelProperty(value = "小计")
private BigDecimal money;

/**
 * primary key
 */
@Override
protected Serializable pkVal(){
        return this.id;
        }
        }
