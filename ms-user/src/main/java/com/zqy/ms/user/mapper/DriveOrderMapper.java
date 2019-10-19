package com.zqy.ms.user.mapper;

import com.zqy.ms.user.entity.DriveOrder;
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
 * @date 2019-10-17 22:18:31
 */
@Mapper
public interface DriveOrderMapper extends BaseMapper<DriveOrder> {

    List<DriveOrder> getDriveOrderListByPage(Page page, @Param("param") Map<String, Object> map);
}
