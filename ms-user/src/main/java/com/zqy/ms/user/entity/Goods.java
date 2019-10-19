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
 * 商品
 *
 * @author Alan
 * @date 2019-10-18 23:18:18
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("goods")
public class Goods extends Model<Goods> {
private static final long serialVersionUID=1L;


        @TableId(type = IdType.UUID)
            @TableField(value = "id")
@ApiModelProperty(value = "")
private String id;

            @TableField(value = "name")
@ApiModelProperty(value = "商品名称")
private String name;

            @TableField(value = "unit")
@ApiModelProperty(value = "单位")
private String unit;

            @TableField(value = "package_unit")
@ApiModelProperty(value = "包装单位")
private String packageUnit;

            @TableField(value = "spec")
@ApiModelProperty(value = "包装规格")
private Integer spec;

                @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @TableField(value = "create_date")
@ApiModelProperty(value = "创建时间")
private Date createDate;

            @TableField(value = "min_store")
@ApiModelProperty(value = "最小库存，小于这个值会报警")
private Integer minStore;

                @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @TableField(value = "update_date")
@ApiModelProperty(value = "修改时间")
private Date updateDate;

            @TableField(value = "store")
@ApiModelProperty(value = "库存")
private Integer store;

            @TableField(value = "organization_id")
@ApiModelProperty(value = "公司id")
private String organizationId;

            @TableField(value = "store_box")
@ApiModelProperty(value = "库存箱数")
private Integer storeBox;

/**
 * primary key
 */
@Override
protected Serializable pkVal(){
        return this.id;
        }
        }
