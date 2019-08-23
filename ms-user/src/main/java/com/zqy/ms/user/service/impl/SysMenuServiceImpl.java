package com.zqy.ms.user.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zqy.ms.user.entity.SysMenu;
import com.zqy.ms.user.mapper.SysMenuMapper;
import com.zqy.ms.user.service.SysMenuService;
import javafx.scene.control.Pagination;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 
 * @author Alan
 * @date 2019-08-23 17:59:18
 */
@Service("sysMenuService")
public class SysMenuServiceImpl extends ServiceImpl<SysMenuMapper, SysMenu> implements SysMenuService {

    @Autowired
    private SysMenuMapper sysMenuMapper;

    @Override
    public List<SysMenu> getSysMenuListByPage(Pagination page, @Param("param") Map<String, Object> map) {
        return sysMenuMapper.getSysMenuListByPage(page, map);
    }

    @Override
    public Set<String> selectPermissionByUserName(String loginName) {
        return sysMenuMapper.selectPermissionByUserName(loginName);
    }
}
