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
 * @date 2019-10-17 22:27:56
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("delivery_order_detail")
public class DeliveryOrderDetail extends Model<DeliveryOrderDetail> {
private static final long serialVersionUID=1L;


        @TableId(type = IdType.UUID)
            @TableField(value = "id")
@ApiModelProperty(value = "")
private String id;

            @TableField(value = "delivery_order_id")
@ApiModelProperty(value = "配送id")
private String deliveryOrderId;

            @TableField(value = "no")
@ApiModelProperty(value = "单号")
private String no;

            @TableField(value = "goods_id")
@ApiModelProperty(value = "货品id")
private String goodsId;

            @TableField(value = "goods_name")
@ApiModelProperty(value = "货品名称")
private String goodsName;

            @TableField(value = "goods_num")
@ApiModelProperty(value = "货品数量=箱数*规格")
private BigDecimal goodsNum;

            @TableField(value = "back_goods_num")
@ApiModelProperty(value = "返回套数")
private BigDecimal backGoodsNum;

            @TableField(value = "box_num")
@ApiModelProperty(value = "箱数")
private BigDecimal boxNum;

            @TableField(value = "back_box_num")
@ApiModelProperty(value = "配送箱数")
private BigDecimal backBoxNum;

            @TableField(value = "spec")
@ApiModelProperty(value = "规格")
private BigDecimal spec;

            @TableField(value = "price")
@ApiModelProperty(value = "价格")
private BigDecimal price;

            @TableField(value = "goods_money")
@ApiModelProperty(value = "小计")
private BigDecimal goodsMoney;

            @TableField(value = "goods_points")
@ApiModelProperty(value = "积分备用")
private BigDecimal goodsPoints;

                @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @TableField(value = "create_date")
@ApiModelProperty(value = "创建时间")
private Date createDate;

            @TableField(value = "package_unit")
@ApiModelProperty(value = "包装单位")
private String packageUnit;

            @TableField(value = "unit")
@ApiModelProperty(value = "单位")
private String unit;

/**
 * primary key
 */
@Override
protected Serializable pkVal(){
        return this.id;
        }
        }
