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
 * @date 2019-10-17 22:18:31
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("drive_order")
public class DriveOrder extends Model<DriveOrder> {
private static final long serialVersionUID=1L;


        @TableId(type = IdType.UUID)
            @TableField(value = "id")
@ApiModelProperty(value = "id")
private String id;

            @TableField(value = "no")
@ApiModelProperty(value = "单号")
private String no;

                @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @TableField(value = "create_date")
@ApiModelProperty(value = "创建时间")
private Date createDate;

            @TableField(value = "operator_id")
@ApiModelProperty(value = "提交人id")
private String operatorId;

            @TableField(value = "operator_name")
@ApiModelProperty(value = "提交人名字")
private String operatorName;

            @TableField(value = "car_no")
@ApiModelProperty(value = "车牌照")
private String carNo;

            @TableField(value = "locked")
@ApiModelProperty(value = "状态是否作废1是作废")
private Boolean locked;

            @TableField(value = "audit")
@ApiModelProperty(value = "0是未审核1是审核通过2是审核拒绝")
private Integer audit;

            @TableField(value = "audit_by")
@ApiModelProperty(value = "审核人")
private String auditBy;

            @TableField(value = "box_num")
@ApiModelProperty(value = "箱数没啥实际意义统计箱子可能用得到")
private BigDecimal boxNum;

            @TableField(value = "goods_num")
@ApiModelProperty(value = "一共个数")
private BigDecimal goodsNum;

            @TableField(value = "drive_back_state")
@ApiModelProperty(value = "0是没有返厂，1是返厂作废")
private Boolean driveBackState;

            @TableField(value = "route_id")
@ApiModelProperty(value = "路线id")
private String routeId;

            @TableField(value = "route_name")
@ApiModelProperty(value = "名称")
private String routeName;

            @TableField(value = "driver_id")
@ApiModelProperty(value = "司机id")
private String driverId;

            @TableField(value = "driver_name")
@ApiModelProperty(value = "司机名称")
private String driverName;

            @TableField(value = "organization_id")
@ApiModelProperty(value = "公司id")
private String organizationId;

            @TableField(value = "state")
@ApiModelProperty(value = "状态0是未配送1是以配送，2是已返厂")
private String state;

            @TableField(value = "remark")
@ApiModelProperty(value = "备注")
private String remark;

            @TableField(value = "left_box_num")
@ApiModelProperty(value = "剩余箱子数量")
private BigDecimal leftBoxNum;

            @TableField(value = "left_goods_num")
@ApiModelProperty(value = "剩余数量")
private BigDecimal leftGoodsNum;

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
