package com.zqy.ms.user.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zqy.ms.user.entity.ForbiddenIp;
import com.zqy.ms.user.mapper.ForbiddenIpMapper;
import com.zqy.ms.user.service.ForbiddenIpService;
import org.springframework.stereotype.Service;

/**
 * 
 *
 * @author Alan
 * @date 2019-07-17 10:57:43
 */
@Service("forbiddenIpService")
public class ForbiddenIpServiceImpl extends ServiceImpl<ForbiddenIpMapper, ForbiddenIp> implements ForbiddenIpService {

}
