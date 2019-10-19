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
import com.zqy.ms.user.mapper.ReceiptOrderMapper;
import com.zqy.ms.user.entity.ReceiptOrder;
import com.zqy.ms.user.service.ReceiptOrderService;
import java.util.List;

/**
 * 
 * @author Alan
 * @date 2019-10-17 22:18:32
 */
@Service("receiptOrderService")
public class ReceiptOrderServiceImpl extends ServiceImpl<ReceiptOrderMapper, ReceiptOrder> implements ReceiptOrderService {

    @Autowired
    private ReceiptOrderMapper receiptOrderMapper;

    @Override
    public List<ReceiptOrder> getReceiptOrderListByPage(Page page, @Param("param") Map<String, Object> map) {
        return receiptOrderMapper.getReceiptOrderListByPage(page, map);
    }
}
