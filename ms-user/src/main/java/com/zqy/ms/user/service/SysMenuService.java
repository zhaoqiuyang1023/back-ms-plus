package com.zqy.ms.user.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zqy.ms.user.entity.SysMenu;
import com.zqy.ms.user.entity.vo.ShowMenu;

import java.util.List;
import java.util.Set;

/**
 *
 * @author Alan
 * @date 2019-08-23 17:59:18
 */
public interface SysMenuService extends IService<SysMenu> {



    List<ShowMenu> findAllTreeShowMenuByUserId(Long id);

    List<SysMenu> findAllTreeMenus();

    List<SysMenu> findAllMenusByRoleId(Long roleId);

    boolean needInterceptor(String requestURI);

    Set<String> findPermissionUrlsByUserId(String userName);

    List<SysMenu> findSysMenusByUserId(Long id);
}

