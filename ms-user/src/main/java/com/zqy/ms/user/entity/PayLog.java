package com.zqy.ms.user.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.Date;


/**
 * @author Alan
 * @date 2019-11-02 16:36:14
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("pay_log")
public class PayLog extends Model<PayLog> {
    private static final long serialVersionUID = 1L;


    @TableId(type = IdType.UUID)
    @TableField(value = "id")
    @ApiModelProperty(value = "")
    private String id;

    @TableField(value = "type")
    @ApiModelProperty(value = "")
    private String type;


    @TableField(value = "money")
    @ApiModelProperty(value = "金额")
    private String money;

    @TableField(value = "organization_id")
    @ApiModelProperty(value = "公司id")
    private String organizationId;

    @TableField(value = "organization_name")
    @ApiModelProperty(value = "公司名称")
    private String organizationName;

    @TableField(value = "user_id")
    @ApiModelProperty(value = "用户id")
    private String userId;

    @TableField(value = "user_name")
    @ApiModelProperty(value = "用户名称")
    private String userName;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @TableField(value = "create_date")
    @ApiModelProperty(value = "创建时间")
    private Date createDate;

    @TableField(value = "num_of_month")
    @ApiModelProperty(value = "几个月")
    private Integer numOfMonth;

    @TableField(value = "admin_id")
    @ApiModelProperty(value = "管理员id")
    private String adminId;

    @TableField(value = "admin_name")
    @ApiModelProperty(value = "管理员名称")
    private String adminName;

    @TableField(value = "before_cut_off_date")
    @ApiModelProperty(value = "充值之前到期时间")
    private Date beforeCutOffDate;

    @TableField(value = "end_cut_off_date")
    @ApiModelProperty(value = "充值之前到期时间")
    private Date endCutOffDate;

    @TableField(value = "pay_policy_id")
    @ApiModelProperty(value = "策略id")
    private String payPolicyId;

    @TableField(value = "trade_no")
    @ApiModelProperty(value = "支付宝流水号")
    private String tradeNo;

    /**
     * primary key
     */
    @Override
    protected Serializable pkVal() {
        return this.id;
    }
}
