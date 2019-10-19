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
import com.zqy.ms.user.mapper.ReceiptOrderDetailMapper;
import com.zqy.ms.user.entity.ReceiptOrderDetail;
import com.zqy.ms.user.service.ReceiptOrderDetailService;
import java.util.List;

/**
 * 
 * @author Alan
 * @date 2019-10-17 22:18:32
 */
@Service("receiptOrderDetailService")
public class ReceiptOrderDetailServiceImpl extends ServiceImpl<ReceiptOrderDetailMapper, ReceiptOrderDetail> implements ReceiptOrderDetailService {

    @Autowired
    private ReceiptOrderDetailMapper receiptOrderDetailMapper;

    @Override
    public List<ReceiptOrderDetail> getReceiptOrderDetailListByPage(Page page, @Param("param") Map<String, Object> map) {
        return receiptOrderDetailMapper.getReceiptOrderDetailListByPage(page, map);
    }
}
