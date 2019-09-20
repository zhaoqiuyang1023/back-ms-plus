package com.zqy.ms.user.mapper;

import com.zqy.ms.user.entity.User;
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
 * @date 2019-09-20 22:46:12
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {

    List<User> getUserListByPage(Page page, @Param("param") Map<String, Object> map);
}
