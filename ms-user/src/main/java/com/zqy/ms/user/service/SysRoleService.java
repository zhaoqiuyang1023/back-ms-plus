package com.zqy.ms.user.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.zqy.ms.user.entity.SysMenu;
import com.zqy.ms.user.entity.SysRole;

import java.util.List;

/**
 * 
 *
 * @author Alan
 * @date 2019-08-01 10:54:19
 */
public interface SysRoleService extends IService<SysRole> {
    void saveRole(SysRole role);

    List<SysMenu> findMenusByRoleId(String id);

    List<SysMenu> findParentMenusByRoleId(Long id);

    /**
     *
     * @param roleId
     * @param parentId
     * @return
     */
    List<SysMenu> findMenusByRoleIdAndParentId(Long roleId,Long parentId);
}

