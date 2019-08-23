package com.zqy.ms.user.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zqy.ms.user.entity.SysMenu;
import javafx.scene.control.Pagination;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 
 *
 * @author Alan
 * @date 2019-08-23 17:59:18
 */
@Mapper
public interface SysMenuMapper extends BaseMapper<SysMenu> {

    List<SysMenu> getSysMenuListByPage(Pagination page, @Param("param") Map<String, Object> map);

    Set<String> selectPermissionByUserName(@Param("loginName") String loginName);
}
