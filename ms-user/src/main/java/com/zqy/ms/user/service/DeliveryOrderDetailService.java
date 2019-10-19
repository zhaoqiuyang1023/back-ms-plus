package com.zqy.ms.user.service;
import org.apache.ibatis.annotations.Param;
import java.util.Map;
import com.baomidou.mybatisplus.extension.service.IService;
import com.zqy.ms.user.entity.DeliveryOrderDetail;
import org.apache.ibatis.annotations.Param;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import java.util.List;
/**
 * 
 * @author Alan
 * @date 2019-10-17 22:27:56
 */
public interface DeliveryOrderDetailService extends IService<DeliveryOrderDetail> {

    List<DeliveryOrderDetail> getDeliveryOrderDetailListByPage(Page page, @Param("param") Map<String, Object> map);
}

