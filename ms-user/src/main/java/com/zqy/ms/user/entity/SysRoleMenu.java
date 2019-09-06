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


/**
 * @author Alan
 * @date 2019-08-01 10:54:19
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("sys_role_menu")
public class SysRoleMenu extends Model<SysRoleMenu> {
    private static final long serialVersionUID = 1L;


    @TableField(value = "role_id")
    @ApiModelProperty(value = "角色id")
    private Long roleId;

    @TableField(value = "menu_id")
    @ApiModelProperty(value = "菜单id")
    private Long menuId;

    /**
     * primary key
     */
    @Override
    protected Serializable pkVal() {
        return this.roleId;
    }
}
