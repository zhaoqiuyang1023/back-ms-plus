package com.zqy.ms.user.mapper;

import com.zqy.ms.user.entity.Organization;
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
 * @date 2019-09-20 21:56:51
 */
@Mapper
public interface OrganizationMapper extends BaseMapper<Organization> {

    List<Organization> getOrganizationListByPage(Page page, @Param("param") Map<String, Object> map);
}
