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
 * @date 2019-08-21 13:27:23
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("visitor_log")
public class VisitorLog extends Model<VisitorLog> {
    private static final long serialVersionUID = 1L;


    @TableId(type = IdType.UUID)
    @TableField(value = "id")
    @ApiModelProperty(value = "")
    private String id;

    @TableField(value = "username")
    @ApiModelProperty(value = "范文名称")
    private String username;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @TableField(value = "date_create")
    @ApiModelProperty(value = "时间")
    private Date dateCreate;

    @TableField(value = "country")
    @ApiModelProperty(value = "国家")
    private String country;

    @TableField(value = "ip")
    @ApiModelProperty(value = "ip地址")
    private String ip;


    @TableField(exist = false)
    @ApiModelProperty(value = "token")
    private String token;

    @TableField(exist = false)
    private Integer page = 1;

    @TableField(exist = false)
    private Integer limit = 10;


    @TableField(exist = false)
    private String beginTime;

    @TableField(exist = false)
    private String endTime;

    /**
     * primary key
     */
    @Override
    protected Serializable pkVal() {
        return this.id;
    }
}
