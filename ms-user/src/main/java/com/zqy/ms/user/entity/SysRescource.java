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
 * 系统资源
 *
 * @author Alan
 * @date 2019-08-01 10:54:19
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("sys_rescource")
public class SysRescource extends Model<SysRescource> {
    private static final long serialVersionUID = 1L;


    @TableId(type = IdType.UUID)
    @TableField(value = "id")
    @ApiModelProperty(value = "主键")
    private Long id;

    @TableField(value = "file_name")
    @ApiModelProperty(value = "文件名称")
    private String fileName;


    @TableField(value = "src")
    @ApiModelProperty(value = "资源网络地址")
    private String src;


    @TableField(value = "file_size")
    @ApiModelProperty(value = "文件大小")
    private String fileSize;

    @TableField(value = "file_type")
    @ApiModelProperty(value = "文件类型")
    private String fileType;

    @TableField(value = "相对路径")
    @ApiModelProperty(value = "")
    private String relativePath;

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


    /**
     * primary key
     */
    @Override
    protected Serializable pkVal() {
        return this.id;
    }
}
