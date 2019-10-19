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
import com.zqy.ms.user.mapper.AdviceLogMapper;
import com.zqy.ms.user.entity.AdviceLog;
import com.zqy.ms.user.service.AdviceLogService;
import java.util.List;

/**
 * 
 * @author Alan
 * @date 2019-10-18 21:06:50
 */
@Service("adviceLogService")
public class AdviceLogServiceImpl extends ServiceImpl<AdviceLogMapper, AdviceLog> implements AdviceLogService {

    @Autowired
    private AdviceLogMapper adviceLogMapper;

    @Override
    public List<AdviceLog> getAdviceLogListByPage(Page page, @Param("param") Map<String, Object> map) {
        return adviceLogMapper.getAdviceLogListByPage(page, map);
    }
}
