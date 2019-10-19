package com.zqy.ms.user.service;
import org.apache.ibatis.annotations.Param;
import java.util.Map;
import com.baomidou.mybatisplus.extension.service.IService;
import com.zqy.ms.user.entity.AdviceLog;
import org.apache.ibatis.annotations.Param;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import java.util.List;
/**
 * 
 * @author Alan
 * @date 2019-10-18 21:06:50
 */
public interface AdviceLogService extends IService<AdviceLog> {

    List<AdviceLog> getAdviceLogListByPage(Page page, @Param("param") Map<String, Object> map);
}

