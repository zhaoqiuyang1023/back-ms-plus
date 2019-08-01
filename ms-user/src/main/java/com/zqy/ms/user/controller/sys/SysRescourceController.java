package com.zqy.ms.user.controller.sys;

import com.zqy.ms.user.service.SysRescourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * 系统资源
 *
 * @author Alan
 * @date 2019-08-01 10:54:19
 */
@RestController
@RequestMapping("/sysrescource")
public class SysRescourceController {
    @Autowired
    private SysRescourceService sysRescourceService;



}
