package com.zqy.ms.user.entity;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.Date;


/**
 * 系统日志
 *
 * @author Alan
 * @date 2019-08-01 10:54:19
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("sys_log")
public class SysLog extends Model<SysLog> {
    private static final long serialVersionUID = 1L;


    @TableId(type = IdType.UUID)
    @TableField(value = "id")
    @ApiModelProperty(value = "编号")
    private String id;

    @TableField(value = "type")
    @ApiModelProperty(value = "请求类型")
    private String type;

    @TableField(value = "title")
    @ApiModelProperty(value = "日志标题")
    private String title;

    @TableField(value = "remote_addr")
    @ApiModelProperty(value = "操作IP地址")
    private String remoteAddr;

    @TableField(value = "username")
    @ApiModelProperty(value = "操作用户昵称")
    private String username;

    @TableField(value = "request_uri")
    @ApiModelProperty(value = "请求URI")
    private String requestUri;

    @TableField(value = "http_method")
    @ApiModelProperty(value = "操作方式")
    private String httpMethod;

    @TableField(value = "class_method")
    @ApiModelProperty(value = "请求类型.方法")
    private String classMethod;

    @TableField(value = "params")
    @ApiModelProperty(value = "操作提交的数据")
    private String params;

    @TableField(value = "session_id")
    @ApiModelProperty(value = "sessionId")
    private String sessionId;

    @TableField(value = "response")
    @ApiModelProperty(value = "返回内容")
    private String response;

    @TableField(value = "use_time")
    @ApiModelProperty(value = "方法执行时间")
    private Long useTime;

    @TableField(value = "browser")
    @ApiModelProperty(value = "浏览器信息")
    private String browser;

    @TableField(value = "area")
    @ApiModelProperty(value = "地区")
    private String area;

    @TableField(value = "province")
    @ApiModelProperty(value = "省")
    private String province;

    @TableField(value = "city")
    @ApiModelProperty(value = "市")
    private String city;

    @TableField(value = "isp")
    @ApiModelProperty(value = "网络服务提供商")
    private String isp;

    @TableField(value = "exception")
    @ApiModelProperty(value = "异常信息")
    private String exception;

    @TableField(value = "create_by")
    @ApiModelProperty(value = "创建者")
    private String createBy;

    @TableField(value = "create_date")
    @ApiModelProperty(value = "创建时间")
    private Date createDate;

    @TableField(value = "update_by")
    @ApiModelProperty(value = "")
    private Long updateBy;

    @TableField(value = "update_date")
    @ApiModelProperty(value = "")
    private Date updateDate;

    @TableField(value = "remarks")
    @ApiModelProperty(value = "")
    private String remarks;

    @TableField(value = "del_flag")
    @ApiModelProperty(value = "")
    private Boolean delFlag;

    /**
     * primary key
     */
    @Override
    protected Serializable pkVal() {
        return this.id;
    }
}
