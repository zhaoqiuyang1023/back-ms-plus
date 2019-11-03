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
 * @author Alan
 * @date 2019-11-01 20:35:15
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("pay_policy")
public class PayPolicy extends Model<PayPolicy> {
    private static final long serialVersionUID = 1L;


    @TableId(type = IdType.UUID)
    @TableField(value = "id")
    @ApiModelProperty(value = "")
    private String id;

    @TableField(value = "duration")
    @ApiModelProperty(value = "几个月")
    private String duration;

    @TableField(value = "type")
    @ApiModelProperty(value = "1是正常0是试用")
    private String type;
    @TableField(value = "remark")
    @ApiModelProperty(value = "1是正常0是试用")
    private String remark;

    @TableField(value = "money")
    @ApiModelProperty(value = "价格")
    private BigDecimal money;

    @TableField(value = "money_of_month")
    @ApiModelProperty(value = "合每月多少钱")
    private BigDecimal moneyOfMonth;

    @TableField(value = "create_date")
    @ApiModelProperty(value = "创建时间")
    private Date createDate;

    @TableField(value = "update_date")
    @ApiModelProperty(value = "修改时间")
    private Date updateDate;


    /**
     * primary key
     */
    @Override
    protected Serializable pkVal() {
        return this.id;
    }
}
