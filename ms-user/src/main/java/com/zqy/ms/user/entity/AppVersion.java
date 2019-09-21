package com.zqy.ms.user.entity;

import com.baomidou.mybatisplus.annotation.*;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.EqualsAndHashCode;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;


/**
 * @author @Alan
 * @date 2019-09-21 10:44:38
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("app_version")
public class AppVersion extends Model<AppVersion> {
    private static final long serialVersionUID = 1L;


    @TableId(type = IdType.UUID)
    @TableField(value = "id")
    @ApiModelProperty(value = "主键")
    private String id;

    @TableField(value = "app_version_no")
    @ApiModelProperty(value = "")
    private Integer appVersionNo;

    @TableField(value = "app_version_name")
    @ApiModelProperty(value = "")
    private String appVersionName;

    @TableField(value = "app_download_url")
    @ApiModelProperty(value = "")
    private String appDownloadUrl;

    @TableField(value = "organization_id")
    @ApiModelProperty(value = "")
    private String organizationId;

    @TableField(value = "force_update")
    @ApiModelProperty(value = "")
    private String forceUpdate;

    @TableField(value = "all_update")
    @ApiModelProperty(value = "")
    private Boolean allUpdate;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @TableField(value = "create_date")
    @ApiModelProperty(value = "")
    private Date createDate;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @TableField(value = "start_time")
    @ApiModelProperty(value = "开始时间")
    private Date startTime;

    /**
     * primary key
     */
    @Override
    protected Serializable pkVal() {
        return this.appVersionNo;
    }
}
