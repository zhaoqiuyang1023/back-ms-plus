package com.zqy.ms.user.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.zqy.ms.user.entity.SysRole;
import com.zqy.ms.user.entity.SysUser;
import com.zqy.ms.user.entity.vo.ShowMenu;

import java.util.List;

/**
 * 
 *
 * @author Alan
 * @date 2019-08-01 10:54:19
 */
public interface SysUserService extends IService<SysUser> {

    List<SysRole> findSysRolesByUserId(Long id);


    void saveUser(SysUser user);

    SysUser findUserById(Long id);

    void deleteUser(SysUser u);

    void updateUser(SysUser user);

    int userCount(String email);

    List<ShowMenu> findShowSysMenusByUserId(Long id);

    boolean saveSysUser(SysUser sysUser);
}

