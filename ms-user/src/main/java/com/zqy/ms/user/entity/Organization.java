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
 * @date 2019-09-20 21:56:51
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("organization")
public class Organization extends Model<Organization> {
    private static final long serialVersionUID = 1L;


    @TableId(type = IdType.UUID)
    @TableField(value = "id")
    @ApiModelProperty(value = "")
    private String id;

    @TableField(value = "name")
    @ApiModelProperty(value = "公司名称")
    private String name;

    @TableField(value = "tel")
    @ApiModelProperty(value = "公司电话")
    private String tel;


    @TableField(value = "del")
    @TableLogic
    @ApiModelProperty(value = "是否删除0是未删除1是已删除")
    private Boolean del;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @TableField(value = "create_date")
    @ApiModelProperty(value = "创建时间")
    private Date createDate;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @TableField(value = "cut_off_date")
    @ApiModelProperty(value = "到期时间")
    private String cutOffDate;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @TableField(value = "update_date")
    @ApiModelProperty(value = "创建时间")
    private Date  updateDate;


    @TableField(value = "locked")
    @ApiModelProperty(value = "1是不可用0是可用")
    private Boolean locked;
    /**
     * primary key
     */
    @Override
    protected Serializable pkVal() {
        return this.id;
    }
}
