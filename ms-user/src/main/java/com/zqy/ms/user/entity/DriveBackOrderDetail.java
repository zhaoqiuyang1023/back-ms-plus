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
 * @date 2019-10-17 22:27:56
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("drive_back_order_detail")
public class DriveBackOrderDetail extends Model<DriveBackOrderDetail> {
private static final long serialVersionUID=1L;


        @TableId(type = IdType.UUID)
            @TableField(value = "id")
@ApiModelProperty(value = "")
private String id;

            @TableField(value = "drive_back_order_id")
@ApiModelProperty(value = "返厂单id")
private String driveBackOrderId;

            @TableField(value = "goods_id")
@ApiModelProperty(value = "商品编号")
private String goodsId;

            @TableField(value = "goods_name")
@ApiModelProperty(value = "商品名称")
private String goodsName;

            @TableField(value = "box_num")
@ApiModelProperty(value = "箱数")
private BigDecimal boxNum;

            @TableField(value = "spec")
@ApiModelProperty(value = "商品规格比如每箱多少件goods_num=box_num*spec")
private BigDecimal spec;

            @TableField(value = "goods_num")
@ApiModelProperty(value = "商品数量")
private BigDecimal goodsNum;

/**
 * primary key
 */
@Override
protected Serializable pkVal(){
        return this.id;
        }
        }
