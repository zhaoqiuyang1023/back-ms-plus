package com.zqy.ms.user.mapper;

import com.zqy.ms.user.entity.AppVersion;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import java.util.List;
import java.util.Map;
/**
 * 
 *
 * @author @Alan
 * @date 2019-09-21 10:44:38
 */
@Mapper
public interface AppVersionMapper extends BaseMapper<AppVersion> {

    List<AppVersion> getAppVersionListByPage(Page page, @Param("param") Map<String, Object> map);
}
