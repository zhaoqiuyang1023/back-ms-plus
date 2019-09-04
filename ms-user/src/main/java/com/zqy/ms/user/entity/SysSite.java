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
 * @author Alan
 * @date 2019-08-01 10:54:19
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("sys_site")
public class SysSite extends Model<SysSite> {
    private static final long serialVersionUID = 1L;


    @TableId(type = IdType.UUID)
    @TableField(value = "id")
    @ApiModelProperty(value = "")
    private Long id;

    @TableField(value = "name")
    @ApiModelProperty(value = "")
    private String name;

    @TableField(value = "url")
    @ApiModelProperty(value = "系统网址")
    private String url;

    @TableField(value = "open_message")
    @ApiModelProperty(value = "是否开放评论")
    private Boolean openMessage;

    @TableField(value = "is_no_name")
    @ApiModelProperty(value = "是否匿名评论")
    private Boolean isNoName;

    @TableField(value = "version")
    @ApiModelProperty(value = "")
    private String version;

    @TableField(value = "author")
    @ApiModelProperty(value = "")
    private String author;

    @TableField(value = "author_icon")
    @ApiModelProperty(value = "")
    private String authorIcon;

    @TableField(value = "file_upload_type")
    @ApiModelProperty(value = "")
    private String fileUploadType;

    @TableField(value = "weibo")
    @ApiModelProperty(value = "")
    private String weibo;

    @TableField(value = "qq")
    @ApiModelProperty(value = "")
    private String qq;

    @TableField(value = "git")
    @ApiModelProperty(value = "")
    private String git;

    @TableField(value = "github")
    @ApiModelProperty(value = "")
    private String github;

    @TableField(value = "phone")
    @ApiModelProperty(value = "")
    private String phone;

    @TableField(value = "email")
    @ApiModelProperty(value = "")
    private String email;

    @TableField(value = "address")
    @ApiModelProperty(value = "")
    private String address;

    @TableField(value = "logo")
    @ApiModelProperty(value = "")
    private String logo;

    @TableField(value = "server")
    @ApiModelProperty(value = "")
    private String server;

    @TableField(value = "database")
    @ApiModelProperty(value = "")
    private String database;

    @TableField(value = "max_upload")
    @ApiModelProperty(value = "")
    private Integer maxUpload;

    @TableField(value = "keywords")
    @ApiModelProperty(value = "")
    private String keywords;

    @TableField(value = "description")
    @ApiModelProperty(value = "")
    private String description;

    @TableField(value = "powerby")
    @ApiModelProperty(value = "")
    private String powerby;

    @TableField(value = "record")
    @ApiModelProperty(value = "")
    private String record;

    @TableField(value = "create_by")
    @ApiModelProperty(value = "")
    private Long createBy;

    @TableField(value = "create_date")
    @ApiModelProperty(value = "")
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
