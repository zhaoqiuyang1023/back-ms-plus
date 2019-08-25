package com.zqy.ms.user.entity.vo;



import com.google.common.collect.Lists;
import com.zqy.ms.user.entity.SysMenu;
import lombok.Data;

import java.io.Serializable;
import java.util.List;


@Data
public class ShowMenu implements Serializable {

    private Long id;
    private Long pid;
    private String name;
    private String icon;
    private String href;
    private String bgColor;
    //是否张开
    private Boolean spread = false;
    private List<SysMenu> children = Lists.newArrayList();

}
