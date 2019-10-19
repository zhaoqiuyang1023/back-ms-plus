package com.zqy.ms.user.mapper;

import com.zqy.ms.user.entity.Car;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import java.util.List;
import java.util.Map;
/**
 * 汽车
 *
 * @author Alan
 * @date 2019-10-18 23:08:59
 */
@Mapper
public interface CarMapper extends BaseMapper<Car> {

    List<Car> getCarListByPage(Page page, @Param("param") Map<String, Object> map);
}
