package com.zqy.ms.user.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zqy.ms.user.entity.SysLog;
import com.zqy.ms.user.mapper.SysLogMapper;
import com.zqy.ms.user.service.SysLogService;
import org.springframework.stereotype.Service;

/**
 * 系统日志
 *
 * @author Alan
 * @date 2019-08-01 10:54:19
 */
@Service("sysLogService")
public class SysLogServiceImpl extends ServiceImpl<SysLogMapper, SysLog> implements SysLogService {

}
