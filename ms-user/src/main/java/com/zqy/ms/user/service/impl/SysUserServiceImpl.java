package com.zqy.ms.user.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zqy.ms.user.entity.SysUser;
import com.zqy.ms.user.mapper.SysUserMapper;
import com.zqy.ms.user.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

/**
 * 
 *
 * @author Alan
 * @date 2019-08-01 10:54:19
 */
@Service("sysUserService")
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUser> implements SysUserService {

    @Autowired
    private SysUserMapper sysUserMapper;

    @Override
    public Set<String> selectRolesByUserName(String loginName) {
        return sysUserMapper.selectRolesByUserName(loginName);
    }
}
