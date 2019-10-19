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
 * 
 *
 * @author Alan
 * @date 2019-10-18 23:08:59
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("route_shop_pk")
public class RouteShopPk extends Model<RouteShopPk> {
private static final long serialVersionUID=1L;


        @TableId(type = IdType.UUID)
            @TableField(value = "id")
@ApiModelProperty(value = "")
private String id;

            @TableField(value = "route_id")
@ApiModelProperty(value = "路线id")
private String routeId;

            @TableField(value = "route_name")
@ApiModelProperty(value = "路线名称")
private String routeName;

            @TableField(value = "shop_id")
@ApiModelProperty(value = "店铺id")
private String shopId;

            @TableField(value = "shop_name")
@ApiModelProperty(value = "店铺名称")
private String shopName;

/**
 * primary key
 */
@Override
protected Serializable pkVal(){
        return this.id;
        }
        }
