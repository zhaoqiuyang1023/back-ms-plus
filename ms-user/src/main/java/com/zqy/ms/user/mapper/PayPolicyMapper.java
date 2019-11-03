package com.zqy.ms.user.mapper;

import com.zqy.ms.user.entity.PayPolicy;
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
 * @date 2019-11-01 20:35:15
 */
@Mapper
public interface PayPolicyMapper extends BaseMapper<PayPolicy> {

    List<PayPolicy> getPayPolicyListByPage(Page page, @Param("param") Map<String, Object> map);
}
