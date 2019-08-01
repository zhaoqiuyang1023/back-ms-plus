package com.zqy.ms.user.controller.sys;

import com.zqy.ms.user.service.SysSiteService;
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
@RequestMapping("/syssite")
public class SysSiteController {
    @Autowired
    private SysSiteService sysSiteService;



}
