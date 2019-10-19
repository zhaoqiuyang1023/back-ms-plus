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
import com.zqy.ms.user.mapper.DeliveryOrderMapper;
import com.zqy.ms.user.entity.DeliveryOrder;
import com.zqy.ms.user.service.DeliveryOrderService;
import java.util.List;

/**
 * 
 * @author Alan
 * @date 2019-10-17 22:18:32
 */
@Service("deliveryOrderService")
public class DeliveryOrderServiceImpl extends ServiceImpl<DeliveryOrderMapper, DeliveryOrder> implements DeliveryOrderService {

    @Autowired
    private DeliveryOrderMapper deliveryOrderMapper;

    @Override
    public List<DeliveryOrder> getDeliveryOrderListByPage(Page page, @Param("param") Map<String, Object> map) {
        return deliveryOrderMapper.getDeliveryOrderListByPage(page, map);
    }
}
