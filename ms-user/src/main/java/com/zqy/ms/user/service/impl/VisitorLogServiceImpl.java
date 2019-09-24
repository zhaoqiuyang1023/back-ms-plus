package com.zqy.ms.user.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zqy.ms.user.entity.VisitorLog;
import com.zqy.ms.user.mapper.VisitorLogMapper;
import com.zqy.ms.user.service.VisitorLogService;
import org.springframework.stereotype.Service;

/**
 * 
 *
 * @author Alan
 * @date 2019-08-21 13:27:23
 */
@Service("visitorLogService")
public class VisitorLogServiceImpl extends ServiceImpl<VisitorLogMapper, VisitorLog> implements VisitorLogService {

}
