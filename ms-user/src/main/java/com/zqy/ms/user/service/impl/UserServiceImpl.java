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
import com.zqy.ms.user.mapper.UserMapper;
import com.zqy.ms.user.entity.User;
import com.zqy.ms.user.service.UserService;
import java.util.List;

/**
 * 
 * @author @Alan
 * @date 2019-09-20 22:46:12
 */
@Service("userService")
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public List<User> getUserListByPage(Page page, @Param("param") Map<String, Object> map) {
        return userMapper.getUserListByPage(page, map);
    }
}
