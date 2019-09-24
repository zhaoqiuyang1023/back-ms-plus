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
 * @date 2019-07-17 10:53:52
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("forbidden_ip")
public class ForbiddenIp extends Model<ForbiddenIp> {
    private static final long serialVersionUID = 1L;


    @TableId(type = IdType.UUID)
    @TableField(value = "id")
    @ApiModelProperty(value = "")
    private String id;

    @TableField(value = "ip")
    private String ip;

    @TableField(value = "country")
    @ApiModelProperty(value = "国家")
    private String country;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @TableField(value = "date_create")
    @ApiModelProperty(value = "创建时间")
    private Date dateCreate;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @TableField(value = "date_update")
    @ApiModelProperty(value = "修改时间")
    private Date dateUpdate;

    @TableField(value = "ip_status")
    @ApiModelProperty(value = "ip状态/0是黑名单，1是解除黑名单")
    private String ipStatus;

    /**
     * primary key
     */
    @Override
    protected Serializable pkVal() {
        return this.id;
    }
}
