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
import java.util.List;
import java.util.Objects;


/**
 * @author Alan
 * @date 2019-08-23 17:59:18
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("sys_menu")
public class SysMenu extends Model<SysMenu> {
    private static final long serialVersionUID = 1L;


    @TableId(type = IdType.UUID)
    @TableField(value = "id")
    @ApiModelProperty(value = "")
    private Long id;

    @TableField(value = "name")
    @ApiModelProperty(value = "菜单名称")
    private String name;

    @TableField(value = "parent_id")
    @ApiModelProperty(value = "父菜单")
    private Long parentId;

    @TableField(value = "level")
    @ApiModelProperty(value = "菜单层级")
    private Long level;

    @TableField(value = "parent_ids")
    @ApiModelProperty(value = "父菜单联集")
    private String parentIds;

    @TableField(value = "sort")
    @ApiModelProperty(value = "排序")
    private Integer sort;

    @TableField(value = "href")
    @ApiModelProperty(value = "链接地址")
    private String href;

    @TableField(value = "target")
    @ApiModelProperty(value = "打开方式")
    private String target;

    @TableField(value = "icon")
    @ApiModelProperty(value = "菜单图标")
    private String icon;

    @TableField(value = "bg_color")
    @ApiModelProperty(value = "显示背景色")
    private String bgColor;

    @TableField(value = "is_show")
    @ApiModelProperty(value = "是否显示")
    private Boolean isShow;

    @TableField(value = "permission")
    @ApiModelProperty(value = "权限标识")
    private String permission;

    @TableField(value = "create_by")
    @ApiModelProperty(value = "")
    private Long createBy;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @TableField(value = "create_date")
    @ApiModelProperty(value = "")
    private Date createDate;

    @TableField(value = "update_by")
    @ApiModelProperty(value = "")
    private Long updateBy;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @TableField(value = "update_date")
    @ApiModelProperty(value = "")
    private Date updateDate;

    @TableField(value = "remarks")
    @ApiModelProperty(value = "")
    private String remarks;

    @TableField(value = "del_flag")
    @ApiModelProperty(value = "")
    private Boolean delFlag;


    @TableField(exist = false)
    private List<SysMenu> childSysMenus;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SysMenu sysMenu = (SysMenu) o;
        return id.equals(sysMenu.id);
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
