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
 * 
 *
 * @author Alan
 * @date 2019-10-15 15:16:57
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("advice_log")
public class AdviceLog extends Model<AdviceLog> {
    private static final long serialVersionUID=1L;

    
    @TableId(type = IdType.UUID)
    @TableField(value = "id")
    @ApiModelProperty(value = "")
    private String id;

    @TableField(value = "tel")
    @ApiModelProperty(value = "")
    private String tel;

    @TableField(value = "username")
    @ApiModelProperty(value = "")
    private String username;

    @TableField(value = "content")
    @ApiModelProperty(value = "")
    private String content;

    @TableField(value = "create_date")
    @ApiModelProperty(value = "")
    private Date createDate;

    @TableField(value = "organization_name")
    @ApiModelProperty(value = "")
    private String organizationName;

/**
 * primary key
 */
@Override
protected Serializable pkVal(){
        return this.id;
        }
        }
