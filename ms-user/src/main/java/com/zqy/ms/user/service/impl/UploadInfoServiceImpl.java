package com.zqy.ms.user.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zqy.ms.user.entity.UploadInfo;
import com.zqy.ms.user.mapper.UploadInfoMapper;
import com.zqy.ms.user.service.UploadInfoService;
import org.springframework.stereotype.Service;

/**
 * 文件上传配置,1,switch-qiniuTestAccess-YES-true-qiniu_test_access,switch-ossTestAccess-YES-true-oss_test_access
 *
 * @author Alan
 * @date 2019-08-01 10:54:19
 */
@Service("uploadInfoService")
public class UploadInfoServiceImpl extends ServiceImpl<UploadInfoMapper, UploadInfo> implements UploadInfoService {

}
