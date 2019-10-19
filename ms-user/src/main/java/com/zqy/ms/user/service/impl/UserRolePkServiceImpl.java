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
import com.zqy.ms.user.mapper.UserRolePkMapper;
import com.zqy.ms.user.entity.UserRolePk;
import com.zqy.ms.user.service.UserRolePkService;
import java.util.List;

/**
 * 
 * @author Alan
 * @date 2019-10-18 23:18:18
 */
@Service("userRolePkService")
public class UserRolePkServiceImpl extends ServiceImpl<UserRolePkMapper, UserRolePk> implements UserRolePkService {


}
