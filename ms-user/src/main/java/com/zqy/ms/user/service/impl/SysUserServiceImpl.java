package com.zqy.ms.user.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zqy.ms.user.entity.SysMenu;
import com.zqy.ms.user.entity.SysRole;
import com.zqy.ms.user.entity.SysUser;
import com.zqy.ms.user.entity.SysUserRole;
import com.zqy.ms.user.entity.vo.ShowMenu;
import com.zqy.ms.user.mapper.SysMenuMapper;
import com.zqy.ms.user.mapper.SysUserMapper;
import com.zqy.ms.user.service.SysRoleService;
import com.zqy.ms.user.service.SysUserRoleService;
import com.zqy.ms.user.service.SysUserService;
import com.zqy.ms.user.util.Log;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Alan
 * @date 2019-08-01 10:54:19
 */
@Service("sysUserService")
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUser> implements SysUserService {

    @Autowired
    private SysUserMapper sysUserMapper;

    @Autowired
    private SysMenuMapper sysMenuMapper;

    @Autowired
    private SysRoleService sysRoleService;

    @Autowired
    private SysUserRoleService sysUserRoleService;



    @Override
    public List<SysRole> findSysRolesByUserId(Long id) {
        return sysUserMapper.findSysRolesByUserId(id);
    }

    @Override
    public List<SysMenu> findSysMenusByUserId(Long id) {

        return sysUserMapper.findSysMenusByUserId(id);
    }

    @Transactional
    @Override
    public void saveUser(SysUser user) {
        sysUserMapper.insert(user);
        for (SysRole sysRole : user.getSysRoles()) {
            SysUserRole sysUserRole = new SysUserRole();
            sysUserRole.setRoleId(sysRole.getId());
            sysUserRole.setUserId(user.getId());
            sysUserRoleService.save(sysUserRole);
        }
    }

    @Override
    public SysUser findUserById(Long id) {
        SysUser sysUser = getById(id);
        sysUser.setSysRoles(findSysRolesByUserId(id));
        return sysUser;
    }

    @Transactional
    @Override
    public void deleteUser(SysUser u) {
        this.removeById(u.getId());
        sysUserRoleService.remove(new QueryWrapper<SysUserRole>().eq("user_id", u.getId()));
    }

    @Override
    public void updateUser(SysUser user) {

    }

    @Override
    public int userCount(String email) {
        return 0;
    }

    @Override
    public List<ShowMenu> findShowSysMenusByUserId(Long id) {
        List<SysMenu> sysMenuList = sysMenuMapper.selectList(new QueryWrapper<SysMenu>().eq("parent_id",0).eq("is_show", "1"));
        Log.i(sysMenuList);
        List<ShowMenu> showMenuList = new ArrayList<>();
        for (SysMenu sysMenu : sysMenuList) {
            ShowMenu showMenu = new ShowMenu();
            BeanUtils.copyProperties(sysMenu, showMenu);
            List<SysMenu> sysMenus = sysMenuMapper.selectList(new QueryWrapper<SysMenu>().eq("parent_id", sysMenu.getId()));
            showMenu.setChildren(sysMenus);
            showMenuList.add(showMenu);
        }

        Log.i(showMenuList);

        return showMenuList;
    }

    @Override
    @Transactional
    public boolean saveSysUser(SysUser sysUser) {
        saveOrUpdate(sysUser);
        sysUserRoleService.remove(new QueryWrapper<SysUserRole>().eq("user_id", sysUser.getId()));
        for (SysRole sysRole : sysUser.getSysRoles()) {
            SysUserRole sysUserRole = new SysUserRole();
            sysUserRole.setUserId(sysUser.getId());
            sysUserRole.setRoleId(sysRole.getId());
            sysUserRoleService.save(sysUserRole);
        }
        return true;
    }


}
