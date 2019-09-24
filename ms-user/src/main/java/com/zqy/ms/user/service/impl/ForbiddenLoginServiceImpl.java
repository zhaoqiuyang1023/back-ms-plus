package com.zqy.ms.user.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zqy.ms.user.entity.ForbiddenLogin;
import com.zqy.ms.user.mapper.ForbiddenLoginMapper;
import com.zqy.ms.user.service.ForbiddenLoginService;
import org.springframework.stereotype.Service;

/**
 * 
 *
 * @author Alan
 * @date 2019-07-17 10:53:52
 */
@Service("forbiddenLoginService")
public class ForbiddenLoginServiceImpl extends ServiceImpl<ForbiddenLoginMapper, ForbiddenLogin> implements ForbiddenLoginService {

}
