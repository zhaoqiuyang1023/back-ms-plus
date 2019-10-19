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
@TableName("delivery_order")
public class DeliveryOrder extends Model<DeliveryOrder> {
    private static final long serialVersionUID = 1L;


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

    @TableField(value = "driver_order_id")
    @ApiModelProperty(value = "装车单id")
    private String driverOrderId;

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

    @TableField(value = "route_id")
    @ApiModelProperty(value = "路线id")
    private String routeId;

    @TableField(value = "route_name")
    @ApiModelProperty(value = "路线名称")
    private String routeName;

    @TableField(value = "locked")
    @ApiModelProperty(value = "是否锁定")
    private Boolean locked;

    @TableField(value = "goods_num")
    @ApiModelProperty(value = "配送套数")
    private BigDecimal goodsNum;

    @TableField(value = "box_num")
    @ApiModelProperty(value = "配送箱数没啥实际意义统计箱子可能用得到")
    private BigDecimal boxNum;

    @TableField(value = "back_goods_num")
    @ApiModelProperty(value = "返回数量")
    private BigDecimal backGoodsNum;

    @TableField(value = "back_box_num")
    @ApiModelProperty(value = "返回箱数")
    private BigDecimal backBoxNum;

    @TableField(value = "organization_id")
    @ApiModelProperty(value = "公司id")
    private String organizationId;

    @TableField(value = "number_of_wreck")
    @ApiModelProperty(value = "折损数")
    private BigDecimal numberOfWreck;

    @TableField(value = "paid")
    @ApiModelProperty(value = "是否已支付")
    private Boolean paid;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @TableField(value = "pay_date")
    @ApiModelProperty(value = "支付时间")
    private Date payDate;

    @TableField(value = "pay_user")
    @ApiModelProperty(value = "支付人")
    private String payUser;

    @TableField(value = "out_storage_id")
    @ApiModelProperty(value = "出库仓")
    private String outStorageId;

    @TableField(value = "in_storage_id")
    @ApiModelProperty(value = "进仓")
    private String inStorageId;

    @TableField(value = "driver_id")
    @ApiModelProperty(value = "司机id")
    private String driverId;

    @TableField(value = "driver_name")
    @ApiModelProperty(value = "司机名称")
    private String driverName;

    @TableField(value = "price")
    @ApiModelProperty(value = "价格")
    private BigDecimal price;

    /**
     * primary key
     */
    @Override
    protected Serializable pkVal() {
        return this.id;
    }
}
