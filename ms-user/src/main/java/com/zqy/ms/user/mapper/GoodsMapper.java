package com.zqy.ms.user.mapper;

import com.zqy.ms.user.entity.Goods;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import java.util.List;
import java.util.Map;
/**
 * 商品
 *
 * @author Alan
 * @date 2019-10-18 23:18:18
 */
@Mapper
public interface GoodsMapper extends BaseMapper<Goods> {

    List<Goods> getGoodsListByPage(Page page, @Param("param") Map<String, Object> map);
}
