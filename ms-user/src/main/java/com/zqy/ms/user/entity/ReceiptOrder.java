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
 * 
 *
 * @author Alan
 * @date 2019-10-17 22:18:32
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("receipt_order")
public class ReceiptOrder extends Model<ReceiptOrder> {
private static final long serialVersionUID=1L;


        @TableId(type = IdType.UUID)
            @TableField(value = "id")
@ApiModelProperty(value = "id")
private String id;

            @TableField(value = "no")
@ApiModelProperty(value = "手机生成唯一标识")
private String no;

            @TableField(value = "shop_id")
@ApiModelProperty(value = "餐厅名称唯一标识")
private String shopId;

            @TableField(value = "shop_name")
@ApiModelProperty(value = "餐厅名称")
private String shopName;

            @TableField(value = "money")
@ApiModelProperty(value = "订单金额")
private BigDecimal money;

            @TableField(value = "operator_id")
@ApiModelProperty(value = "操作人标识")
private String operatorId;

            @TableField(value = "operator_name")
@ApiModelProperty(value = "操作人姓名")
private String operatorName;

            @TableField(value = "remark")
@ApiModelProperty(value = "备注")
private String remark;

                @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @TableField(value = "create_date")
@ApiModelProperty(value = "创建时间")
private Date createDate;

            @TableField(value = "signature_image")
@ApiModelProperty(value = "签名图片url")
private String signatureImage;

            @TableField(value = "locked")
@ApiModelProperty(value = "是否锁定")
private Boolean locked;

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
