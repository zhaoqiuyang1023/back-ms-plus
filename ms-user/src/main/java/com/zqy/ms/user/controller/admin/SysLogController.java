package com.zqy.ms.user.controller.admin;

import com.zqy.ms.user.service.SysLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * 系统日志
 *
 * @author Alan
 * @date 2019-08-01 10:54:19
 */
@RestController
@RequestMapping("/syslog")
public class SysLogController {
    @Autowired
    private SysLogService sysLogService;



}
