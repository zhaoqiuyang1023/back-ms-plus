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
import com.zqy.ms.user.mapper.GoodsMapper;
import com.zqy.ms.user.entity.Goods;
import com.zqy.ms.user.service.GoodsService;
import java.util.List;

/**
 * 商品
 * @author Alan
 * @date 2019-10-18 23:18:18
 */
@Service("goodsService")
public class GoodsServiceImpl extends ServiceImpl<GoodsMapper, Goods> implements GoodsService {

    @Autowired
    private GoodsMapper goodsMapper;

    @Override
    public List<Goods> getGoodsListByPage(Page page, @Param("param") Map<String, Object> map) {
        return goodsMapper.getGoodsListByPage(page, map);
    }
}
