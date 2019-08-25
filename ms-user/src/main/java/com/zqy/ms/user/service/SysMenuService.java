package com.zqy.ms.user.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.zqy.ms.user.entity.SysMenu;
import com.zqy.ms.user.entity.vo.ShowMenu;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author Alan
 * @date 2019-08-23 17:59:18
 */
public interface SysMenuService extends IService<SysMenu> {

    List<SysMenu> getSysMenuListByPage(Page page, @Param("param") Map<String, Object> map);

    Set<String> selectPermissionByUserName(String loginName);

    List<ShowMenu> getShowMenuByUser(Long id);
}

