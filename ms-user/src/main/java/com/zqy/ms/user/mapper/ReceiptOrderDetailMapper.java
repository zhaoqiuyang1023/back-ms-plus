package com.zqy.ms.user.mapper;

import com.zqy.ms.user.entity.ReceiptOrderDetail;
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
 * @date 2019-10-17 22:18:32
 */
@Mapper
public interface ReceiptOrderDetailMapper extends BaseMapper<ReceiptOrderDetail> {

    List<ReceiptOrderDetail> getReceiptOrderDetailListByPage(Page page, @Param("param") Map<String, Object> map);
}
