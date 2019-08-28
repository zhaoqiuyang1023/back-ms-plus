package com.zqy.ms.user.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zqy.ms.user.entity.SysMenu;
import com.zqy.ms.user.entity.SysRole;
import com.zqy.ms.user.entity.SysRoleMenu;
import com.zqy.ms.user.entity.SysUserRole;
import com.zqy.ms.user.mapper.SysRoleMapper;
import com.zqy.ms.user.mapper.SysRoleMenuMapper;
import com.zqy.ms.user.service.SysRoleMenuService;
import com.zqy.ms.user.service.SysRoleService;
import com.zqy.ms.user.service.SysUserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author Alan
 * @date 2019-08-01 10:54:19
 */
@Service("sysRoleService")
public class SysRoleServiceImpl extends ServiceImpl<SysRoleMapper, SysRole> implements SysRoleService {

    @Autowired
    private SysRoleMapper sysRoleMapper;

    @Autowired
    private SysRoleMenuMapper sysRoleMenuMapper;


    @Autowired
    private SysUserRoleService sysUserRoleService;


    @Autowired
    private SysRoleMenuService sysRoleMenuService;


    @Transactional
    @Override
    public void saveRole(SysRole role) {
        saveOrUpdate(role);
        sysRoleMenuMapper.delete(new QueryWrapper<SysRoleMenu>().eq("role_id", role.getId()));
        for (SysMenu sysMenu : role.getSysMenus()) {
            SysRoleMenu sysRoleMenu = new SysRoleMenu();
            sysRoleMenu.setMenuId(sysMenu.getId());
            sysRoleMenu.setRoleId(role.getId());
            sysRoleMenuMapper.insert(sysRoleMenu);
        }


    }

    @Override
    public List<SysMenu> findMenusByRoleId(Long id) {
        return sysRoleMapper.findMenusByRoleId(id);
    }

    @Override
    public List<SysMenu> findParentMenusByRoleId(Long id) {
        return sysRoleMapper.findParentMenusByRoleId(id);
    }

    @Override
    public List<SysMenu> findMenusByRoleIdAndParentId(Long roleId, Long parentId) {

        return  sysRoleMapper.findMenusByRoleIdAndParentId(roleId, parentId);
    }

    @Override
    @Transactional
    public void deleteRoleByRoleId(Long id) {
        removeById(id);
        sysUserRoleService.remove(new QueryWrapper<SysUserRole>().eq("role_id",id));
        sysRoleMenuService.remove(new QueryWrapper<SysRoleMenu>().eq("role_id",id));
    }
}
