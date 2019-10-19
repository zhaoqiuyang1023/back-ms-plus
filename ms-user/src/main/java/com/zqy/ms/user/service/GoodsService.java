package com.zqy.ms.user.service;
import org.apache.ibatis.annotations.Param;
import java.util.Map;
import com.baomidou.mybatisplus.extension.service.IService;
import com.zqy.ms.user.entity.Goods;
import org.apache.ibatis.annotations.Param;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import java.util.List;
/**
 * 商品
 * @author Alan
 * @date 2019-10-18 23:18:18
 */
public interface GoodsService extends IService<Goods> {

    List<Goods> getGoodsListByPage(Page page, @Param("param") Map<String, Object> map);
}

