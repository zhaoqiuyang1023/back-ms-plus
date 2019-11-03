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
import com.zqy.ms.user.mapper.PayLogMapper;
import com.zqy.ms.user.entity.PayLog;
import com.zqy.ms.user.service.PayLogService;
import java.util.List;

/**
 * 
 * @author Alan
 * @date 2019-11-01 20:35:15
 */
@Service("payLogService")
public class PayLogServiceImpl extends ServiceImpl<PayLogMapper, PayLog> implements PayLogService {

    @Autowired
    private PayLogMapper payLogMapper;

    @Override
    public List<PayLog> getPayLogListByPage(Page page, @Param("param") Map<String, Object> map) {
        return payLogMapper.getPayLogListByPage(page, map);
    }
}
