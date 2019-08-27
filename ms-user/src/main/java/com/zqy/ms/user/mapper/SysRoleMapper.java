package com.zqy.ms.user.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zqy.ms.user.entity.SysMenu;
import com.zqy.ms.user.entity.SysRole;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 
 *
 * @author Alan
 * @date 2019-08-01 10:54:19
 */
@Mapper
public interface SysRoleMapper extends BaseMapper<SysRole> {

    List<SysMenu> findMenusByRoleId(@Param("id") String id);

    List<SysMenu> findParentMenusByRoleId(Long id);
}
