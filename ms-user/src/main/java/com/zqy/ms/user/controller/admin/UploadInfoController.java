package com.zqy.ms.user.controller.admin;

import com.zqy.ms.user.service.UploadInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * 文件上传配置,1,switch-qiniuTestAccess-YES-true-qiniu_test_access,switch-ossTestAccess-YES-true-oss_test_access
 *
 * @author Alan
 * @date 2019-08-01 10:54:19
 */
@RestController
@RequestMapping("/uploadinfo")
public class UploadInfoController {
    @Autowired
    private UploadInfoService uploadInfoService;


}
