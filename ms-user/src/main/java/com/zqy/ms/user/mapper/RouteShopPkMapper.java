package com.zqy.ms.user.mapper;

import com.zqy.ms.user.entity.RouteShopPk;
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
 * @date 2019-10-18 23:08:59
 */
@Mapper
public interface RouteShopPkMapper extends BaseMapper<RouteShopPk> {

    List<RouteShopPk> getRouteShopPkListByPage(Page page, @Param("param") Map<String, Object> map);
}
