package com.zqy.ms.user.controller.sys;

import com.zqy.ms.user.service.SysRoleMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * 
 *
 * @author Alan
 * @date 2019-08-01 10:54:19
 */
@RestController
@RequestMapping("/sysrolemenu")
public class SysRoleMenuController {
    @Autowired
    private SysRoleMenuService sysRoleMenuService;



}
