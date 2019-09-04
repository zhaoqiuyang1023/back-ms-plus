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
import java.util.List;
import java.util.Objects;


/**
 * @author Alan
 * @date 2019-08-01 10:54:19
 */
@Data
@TableName("sys_role")
public class SysRole extends Model<SysRole> {
    private static final long serialVersionUID = 1L;


    @TableId(type = IdType.AUTO)
    @TableField(value = "id")
    @ApiModelProperty(value = "")
    private Long id;

    @TableField(value = "name")
    @ApiModelProperty(value = "角色名称")
    private String name;

    @TableField(value = "create_date")
    @ApiModelProperty(value = "")
    private Date createDate;

    @TableField(value = "create_by")
    @ApiModelProperty(value = "")
    private Long createBy;

    @TableField(value = "update_date")
    @ApiModelProperty(value = "")
    private Date updateDate;

    @TableField(value = "update_by")
    @ApiModelProperty(value = "")
    private Long updateBy;

    @TableField(value = "remarks")
    @ApiModelProperty(value = "")
    private String remarks;

    @TableField(value = "del_flag")
    @ApiModelProperty(value = "")
    private Boolean delFlag;

    @TableField(exist = false)
    @ApiModelProperty(value = "")
    private List<SysMenu> sysMenus;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SysRole sysRole = (SysRole) o;
        return Objects.equals(id, sysRole.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    /**
     * primary key
     */
    @Override
    protected Serializable pkVal() {
        return this.id;
    }
}
