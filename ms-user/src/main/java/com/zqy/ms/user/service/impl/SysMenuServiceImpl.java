package com.zqy.ms.user.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zqy.ms.user.entity.SysMenu;
import com.zqy.ms.user.entity.SysUser;
import com.zqy.ms.user.entity.vo.ShowMenu;
import com.zqy.ms.user.mapper.SysMenuMapper;
import com.zqy.ms.user.mapper.SysRoleMapper;
import com.zqy.ms.user.service.SysMenuService;
import com.zqy.ms.user.util.Log;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author Alan
 * @date 2019-08-23 17:59:18
 */
@Service("sysMenuService")
public class SysMenuServiceImpl extends ServiceImpl<SysMenuMapper, SysMenu> implements SysMenuService {


    @Autowired
    private SysMenuMapper sysMenuMapper;

    @Autowired
    private SysRoleMapper sysRoleMapper;

    @Override
    public List<SysMenu> getSysMenuListByPage(Page page, @Param("param") Map<String, Object> map) {
        return sysMenuMapper.getSysMenuListByPage(page, map);
    }

    @Override
    public Set<String> selectPermissionByUserName(String loginName) {
        return sysMenuMapper.selectPermissionByUserName(loginName);
    }

    @Override
    public List<ShowMenu> getShowMenuByUser(Long id) {
        return null;
    }

    @Override
    public List<SysMenu> findAllMenusByLevel() {
        List<SysMenu> parentSysMenuList = sysMenuMapper.selectList(new QueryWrapper<SysMenu>().isNull("parent_id"));
        recursion(parentSysMenuList);
        Log.i(parentSysMenuList);
        return parentSysMenuList;
    }

    @Override
    public List<SysMenu> findAllMenusByLevel(Long id) {
        //找到最顶层的集合菜单
        List<SysMenu> parentSysMenuList = sysRoleMapper.findParentMenusByRoleId(id);
        recursion(parentSysMenuList);
        Log.i(parentSysMenuList);
        return parentSysMenuList;
    }

    private void recursion(List<SysMenu> parentSysMenuList) {
        for (SysMenu sysMenu : parentSysMenuList) {
            List<SysMenu> sysMenus = sysMenuMapper.selectList(new QueryWrapper<SysMenu>().eq("parent_id", sysMenu.getId()));
            Log.i("有二级及以下菜单");
            if(sysMenus.size()>0){
                sysMenu.setChildSysMenus(sysMenus);
                recursion(sysMenus);
            }

        }
    }
}
