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
import com.zqy.ms.user.mapper.PayPolicyMapper;
import com.zqy.ms.user.entity.PayPolicy;
import com.zqy.ms.user.service.PayPolicyService;
import java.util.List;

/**
 * 
 * @author Alan
 * @date 2019-11-01 20:35:15
 */
@Service("payPolicyService")
public class PayPolicyServiceImpl extends ServiceImpl<PayPolicyMapper, PayPolicy> implements PayPolicyService {

    @Autowired
    private PayPolicyMapper payPolicyMapper;

    @Override
    public List<PayPolicy> getPayPolicyListByPage(Page page, @Param("param") Map<String, Object> map) {
        return payPolicyMapper.getPayPolicyListByPage(page, map);
    }
}
