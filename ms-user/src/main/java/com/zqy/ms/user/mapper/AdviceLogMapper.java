package com.zqy.ms.user.mapper;

import com.zqy.ms.user.entity.AdviceLog;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import java.util.List;
import java.util.Map;
/**
 * 
 *
 * @author Alan
 * @date 2019-10-18 21:06:50
 */
@Mapper
public interface AdviceLogMapper extends BaseMapper<AdviceLog> {

    List<AdviceLog> getAdviceLogListByPage(Page page, @Param("param") Map<String, Object> map);
}
