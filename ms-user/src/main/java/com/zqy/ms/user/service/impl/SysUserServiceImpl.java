package com.zqy.ms.user.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.additional.query.impl.QueryChainWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zqy.ms.user.entity.*;
import com.zqy.ms.user.entity.vo.ShowMenu;
import com.zqy.ms.user.mapper.SysMenuMapper;
import com.zqy.ms.user.mapper.SysRoleMapper;
import com.zqy.ms.user.mapper.SysUserMapper;
import com.zqy.ms.user.service.SysMenuService;
import com.zqy.ms.user.service.SysRoleService;
import com.zqy.ms.user.service.SysUserRoleService;
import com.zqy.ms.user.service.SysUserService;
import com.zqy.ms.user.util.Log;
import net.bytebuddy.asm.Advice;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.management.relation.Role;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

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
    public Set<String> selectRolesByUserName(String loginName) {
        return sysUserMapper.selectRolesByUserName(loginName);
    }

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
        return null;
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
        List<SysMenu> sysMenuList = sysMenuMapper.selectList(new QueryWrapper<SysMenu>().isNull("parent_id").eq("is_show", "1"));
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
}
