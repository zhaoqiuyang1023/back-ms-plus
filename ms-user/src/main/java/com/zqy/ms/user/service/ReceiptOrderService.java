package com.zqy.ms.user.service;
import org.apache.ibatis.annotations.Param;
import java.util.Map;
import com.baomidou.mybatisplus.extension.service.IService;
import com.zqy.ms.user.entity.ReceiptOrder;
import org.apache.ibatis.annotations.Param;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import java.util.List;
/**
 * 
 * @author Alan
 * @date 2019-10-17 22:18:32
 */
public interface ReceiptOrderService extends IService<ReceiptOrder> {

    List<ReceiptOrder> getReceiptOrderListByPage(Page page, @Param("param") Map<String, Object> map);
}

