package com.zqy.ms.user.service;
import org.apache.ibatis.annotations.Param;
import java.util.Map;
import com.baomidou.mybatisplus.extension.service.IService;
import com.zqy.ms.user.entity.PayPolicy;
import org.apache.ibatis.annotations.Param;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import java.util.List;
/**
 * 
 * @author Alan
 * @date 2019-11-01 20:35:15
 */
public interface PayPolicyService extends IService<PayPolicy> {

    List<PayPolicy> getPayPolicyListByPage(Page page, @Param("param") Map<String, Object> map);
}

