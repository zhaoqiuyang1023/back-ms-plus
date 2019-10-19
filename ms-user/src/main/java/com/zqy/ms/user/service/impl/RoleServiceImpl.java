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
import com.zqy.ms.user.mapper.RoleMapper;
import com.zqy.ms.user.entity.Role;
import com.zqy.ms.user.service.RoleService;
import java.util.List;

/**
 * 
 * @author Alan
 * @date 2019-10-18 23:18:18
 */
@Service("roleService")
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role> implements RoleService {

    @Autowired
    private RoleMapper roleMapper;


}
