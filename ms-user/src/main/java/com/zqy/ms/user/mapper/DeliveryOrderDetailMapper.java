package com.zqy.ms.user.mapper;

import com.zqy.ms.user.entity.DeliveryOrderDetail;
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
 * @date 2019-10-17 22:27:56
 */
@Mapper
public interface DeliveryOrderDetailMapper extends BaseMapper<DeliveryOrderDetail> {

    List<DeliveryOrderDetail> getDeliveryOrderDetailListByPage(Page page, @Param("param") Map<String, Object> map);
}
