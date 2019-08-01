package com.zqy.ms.user.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.zqy.ms.user.entity.SysUser;

import java.util.Set;

/**
 * 
 *
 * @author Alan
 * @date 2019-08-01 10:54:19
 */
public interface SysUserService extends IService<SysUser> {
    Set<String> selectRolesByUserName(String loginName);
}

