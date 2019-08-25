package com.zqy.ms.user.controller.admin;

import com.zqy.ms.user.service.SysDictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * 字典表,测试表
 *
 * @author Alan
 * @date 2019-08-01 10:54:19
 */
@RestController
@RequestMapping("/sysdict")
public class SysDictController {
    @Autowired
    private SysDictService sysDictService;


}
