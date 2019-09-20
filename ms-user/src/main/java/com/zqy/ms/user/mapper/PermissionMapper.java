package com.zqy.ms.user.mapper;

import com.zqy.ms.user.entity.Permission;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import java.util.List;
import java.util.Map;
/**
 * 
 *
 * @author @Alan
 * @date 2019-09-20 20:49:27
 */
@Mapper
public interface PermissionMapper extends BaseMapper<Permission> {

    List<Permission> getPermissionListByPage(Page page, @Param("param") Map<String, Object> map);
}
