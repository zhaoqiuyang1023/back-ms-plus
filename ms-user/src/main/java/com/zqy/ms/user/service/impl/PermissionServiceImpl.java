package com.zqy.ms.user.service.impl;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Map;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.ibatis.annotations.Param;
import java.util.Map;
import javafx.scene.control.Pagination;
import com.zqy.ms.user.mapper.PermissionMapper;
import com.zqy.ms.user.entity.Permission;
import com.zqy.ms.user.service.PermissionService;
import java.util.List;

/**
 * 
 * @author @Alan
 * @date 2019-09-20 22:11:04
 */
@Service("permissionService")
public class PermissionServiceImpl extends ServiceImpl<PermissionMapper, Permission> implements PermissionService {

    @Autowired
    private PermissionMapper permissionMapper;

    @Override
    public List<Permission> getPermissionListByPage(Page page, @Param("param") Map<String, Object> map) {
        return permissionMapper.getPermissionListByPage(page, map);
    }
}
