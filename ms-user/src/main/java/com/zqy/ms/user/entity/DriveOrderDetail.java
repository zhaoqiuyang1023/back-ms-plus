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
@TableName("drive_order_detail")
public class DriveOrderDetail extends Model<DriveOrderDetail> {
private static final long serialVersionUID=1L;


        @TableId(type = IdType.UUID)
            @TableField(value = "id")
@ApiModelProperty(value = "")
private String id;

            @TableField(value = "drive_order_id")
@ApiModelProperty(value = "装车id")
private String driveOrderId;

            @TableField(value = "no")
@ApiModelProperty(value = "装车单单号")
private String no;

            @TableField(value = "goods_id")
@ApiModelProperty(value = "商品编号")
private String goodsId;

            @TableField(value = "goods_name")
@ApiModelProperty(value = "商品名称")
private String goodsName;

            @TableField(value = "spec")
@ApiModelProperty(value = "规格")
private BigDecimal spec;

            @TableField(value = "box_num")
@ApiModelProperty(value = "箱数")
private BigDecimal boxNum;

            @TableField(value = "goods_num")
@ApiModelProperty(value = "商品数量")
private BigDecimal goodsNum;

            @TableField(value = "unit")
@ApiModelProperty(value = "单位")
private String unit;

            @TableField(value = "package_unit")
@ApiModelProperty(value = "包装单位")
private String packageUnit;

            @TableField(value = "left_goods_num")
@ApiModelProperty(value = "可配送剩余数量")
private BigDecimal leftGoodsNum;

            @TableField(value = "left_box_num")
@ApiModelProperty(value = "可配送剩余箱子数量")
private BigDecimal leftBoxNum;

            @TableField(value = "back_goods_num")
@ApiModelProperty(value = "拉回套数")
private BigDecimal backGoodsNum;

            @TableField(value = "back_box_num")
@ApiModelProperty(value = "拉回箱数")
private BigDecimal backBoxNum;

/**
 * primary key
 */
@Override
protected Serializable pkVal(){
        return this.id;
        }
        }
