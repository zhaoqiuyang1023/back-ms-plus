package com.zqy.ms.user.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zqy.ms.user.entity.UploadInfo;
import org.apache.ibatis.annotations.Mapper;

/**
 * 文件上传配置,1,switch-qiniuTestAccess-YES-true-qiniu_test_access,switch-ossTestAccess-YES-true-oss_test_access
 *
 * @author Alan
 * @date 2019-08-01 10:54:19
 */
@Mapper
public interface UploadInfoMapper extends BaseMapper<UploadInfo> {

}
