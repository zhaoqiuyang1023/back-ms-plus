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
 * 文件上传配置,1,switch-qiniuTestAccess-YES-true-qiniu_test_access,switch-ossTestAccess-YES-true-oss_test_access
 *
 * @author Alan
 * @date 2019-08-01 10:54:19
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("upload_info")
public class UploadInfo extends Model<UploadInfo> {
private static final long serialVersionUID=1L;


        @TableId(type = IdType.UUID)
    @TableField(value = "id")
@ApiModelProperty(value = "主键")
private Long id;

    @TableField(value = "local_window_url")
@ApiModelProperty(value = "本地window系统上传路径,input,YES,false,true,false")
private String localWindowUrl;

    @TableField(value = "local_linux_url")
@ApiModelProperty(value = "本地LINUX系统上传路径,input,YES,false,true,false")
private String localLinuxUrl;

    @TableField(value = "qiniu_base_path")
@ApiModelProperty(value = "七牛前缀路径,input,YES,false,true,false")
private String qiniuBasePath;

    @TableField(value = "qiniu_bucket_name")
@ApiModelProperty(value = "七牛bucket的目录名称,input,YES,false,true,false")
private String qiniuBucketName;

    @TableField(value = "qiniu_dir")
@ApiModelProperty(value = "七牛文件存储目录,input,YES,false,true,false")
private String qiniuDir;

    @TableField(value = "qiniu_access_key")
@ApiModelProperty(value = "七牛qiniuAccess值,input,YES,false,true,false")
private String qiniuAccessKey;

    @TableField(value = "qiniu_secret_key")
@ApiModelProperty(value = "七牛qiniuKey的值,input,YES,false,true,false")
private String qiniuSecretKey;

    @TableField(value = "qiniu_test_access")
@ApiModelProperty(value = "七牛上传测试,switch,YES,true,true,false")
private Boolean qiniuTestAccess;

    @TableField(value = "oss_base_path")
@ApiModelProperty(value = "阿里云前缀路径,input,YES,false,true,false")
private String ossBasePath;

    @TableField(value = "oss_bucket_name")
@ApiModelProperty(value = "阿里云bucket的目录名称,input,YES,false,true,false")
private String ossBucketName;

    @TableField(value = "oss_dir")
@ApiModelProperty(value = "阿里云文件上传目录,input,YES,false,true,false")
private String ossDir;

    @TableField(value = "oss_key_id")
@ApiModelProperty(value = "阿里云ACCESS_KEY_ID值,input,YES,false,true,false")
private String ossKeyId;

    @TableField(value = "oss_key_secret")
@ApiModelProperty(value = "阿里云ACCESS_KEY_SECRET,input,YES,false,true,false")
private String ossKeySecret;

    @TableField(value = "oss_endpoint")
@ApiModelProperty(value = "阿里云ENDPOINT值,input,YES,false,true,false")
private String ossEndpoint;

    @TableField(value = "oss_test_access")
@ApiModelProperty(value = "阿里云上传测试,switch,YES,true,true,false")
private Boolean ossTestAccess;

    @TableField(value = "create_date")
@ApiModelProperty(value = "创建时间")
private Date createDate;

    @TableField(value = "create_by")
@ApiModelProperty(value = "创建人")
private Long createBy;

    @TableField(value = "update_date")
@ApiModelProperty(value = "修改时间")
private Date updateDate;

    @TableField(value = "update_by")
@ApiModelProperty(value = "修改人")
private Long updateBy;

    @TableField(value = "remarks")
@ApiModelProperty(value = "备注")
private String remarks;

    @TableField(value = "del_flag")
@ApiModelProperty(value = "删除标记")
private Boolean delFlag;

/**
 * primary key
 */
@Override
protected Serializable pkVal(){
        return this.id;
        }
        }
