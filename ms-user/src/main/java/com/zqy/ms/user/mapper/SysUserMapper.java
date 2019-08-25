package com.zqy.ms.user.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zqy.ms.user.entity.SysMenu;
import com.zqy.ms.user.entity.SysRole;
import com.zqy.ms.user.entity.SysUser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Set;

/**
 * 
 *
 * @author Alan
 * @date 2019-08-01 10:54:19
 */
@Mapper
public interface SysUserMapper extends BaseMapper<SysUser> {

    /**
     *
     * @param loginName
     * @return
     */
    Set<String> selectRolesByUserName(@Param("loginName") String loginName);

    List<SysRole> findSysRolesByUserId(Long id);

    List<SysMenu> findSysMenusByUserId(Long id);
}
