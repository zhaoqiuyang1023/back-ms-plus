package com.zqy.ms.user.service;
import org.apache.ibatis.annotations.Param;
import java.util.Map;
import com.baomidou.mybatisplus.extension.service.IService;
import com.zqy.ms.user.entity.Permission;
import org.apache.ibatis.annotations.Param;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import java.util.List;
/**
 * 
 * @author @Alan
 * @date 2019-09-20 20:49:27
 */
public interface PermissionService extends IService<Permission> {

    List<Permission> getPermissionListByPage(Page page, @Param("param") Map<String, Object> map);
}

