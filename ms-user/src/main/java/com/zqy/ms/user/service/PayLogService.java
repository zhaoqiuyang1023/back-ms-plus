package com.zqy.ms.user.service;
import org.apache.ibatis.annotations.Param;
import java.util.Map;
import com.baomidou.mybatisplus.extension.service.IService;
import com.zqy.ms.user.entity.PayLog;
import org.apache.ibatis.annotations.Param;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import java.util.List;
/**
 * 
 * @author Alan
 * @date 2019-11-01 20:35:15
 */
public interface PayLogService extends IService<PayLog> {

    List<PayLog> getPayLogListByPage(Page page, @Param("param") Map<String, Object> map);
}

