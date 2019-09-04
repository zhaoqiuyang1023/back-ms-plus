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
@TableName("sys_user_role")
public class SysUserRole extends Model<SysUserRole> {
    private static final long serialVersionUID = 1L;


    @TableField(value = "user_id")
    @ApiModelProperty(value = "")
    private Long userId;

    @TableField(value = "role_id")
    @ApiModelProperty(value = "")
    private Long roleId;

    /**
     * primary key
     */
    @Override
    protected Serializable pkVal() {
        return this.userId;
    }
}
