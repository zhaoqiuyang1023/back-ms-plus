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
@TableName("hat_area")
public class HatArea extends Model<HatArea> {
    private static final long serialVersionUID = 1L;


    @TableId(type = IdType.UUID)
    @TableField(value = "id")
    @ApiModelProperty(value = "")
    private Integer id;

    @TableField(value = "areaID")
    @ApiModelProperty(value = "")
    private String areaid;

    @TableField(value = "area")
    @ApiModelProperty(value = "")
    private String area;

    @TableField(value = "father")
    @ApiModelProperty(value = "")
    private String father;

    /**
     * primary key
     */
    @Override
    protected Serializable pkVal() {
        return this.id;
    }
}
