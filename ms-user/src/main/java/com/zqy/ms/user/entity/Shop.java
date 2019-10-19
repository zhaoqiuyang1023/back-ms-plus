package com.zqy.ms.user.entity;

import com.baomidou.mybatisplus.annotation.*;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;
import lombok.EqualsAndHashCode;
import io.swagger.annotations.ApiModelProperty;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.util.Date;
import java.math.BigDecimal;


/**
 * 
 *
 * @author Alan
 * @date 2019-10-18 23:27:19
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("shop")
public class Shop extends Model<Shop> {
private static final long serialVersionUID=1L;


        @TableId(type = IdType.UUID)
            @TableField(value = "id")
@ApiModelProperty(value = "")
private String id;

            @TableField(value = "name")
@ApiModelProperty(value = "店铺名称")
private String name;

            @TableField(value = "tel")
@ApiModelProperty(value = "手机号")
private String tel;

            @TableField(value = "boss")
@ApiModelProperty(value = "老板")
private String boss;

            @TableField(value = "locked")
@ApiModelProperty(value = "是否可用0是可用1是不可用")
private Boolean locked;

                @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @TableField(value = "create_date")
@ApiModelProperty(value = "创建时间")
private Date createDate;

            @TableField(value = "organization_id")
@ApiModelProperty(value = "公司id")
private String organizationId;

            @TableField(value = "sort")
@ApiModelProperty(value = "排序")
private Integer sort;

            @TableField(value = "min_store")
@ApiModelProperty(value = "最小库存，小于这个值会报警")
private Integer minStore;

            @TableField(value = "receipt_time")
@ApiModelProperty(value = "收款日")
private Integer receiptTime;

            @TableField(value = "store")
@ApiModelProperty(value = "店存")
private Integer store;

            @TableField(value = "price")
@ApiModelProperty(value = "价格")
private BigDecimal price;

            @TableField(value = "address")
@ApiModelProperty(value = "地址信息")
private String address;

/**
 * primary key
 */
@Override
protected Serializable pkVal(){
        return this.id;
        }
        }
