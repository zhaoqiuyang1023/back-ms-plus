package com.zqy.ms.user.service;
import org.apache.ibatis.annotations.Param;
import java.util.Map;
import com.baomidou.mybatisplus.extension.service.IService;
import com.zqy.ms.user.entity.Organization;
import org.apache.ibatis.annotations.Param;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import java.util.List;
/**
 * 
 * @author @Alan
 * @date 2019-09-20 21:56:51
 */
public interface OrganizationService extends IService<Organization> {

    List<Organization> getOrganizationListByPage(Page page, @Param("param") Map<String, Object> map);
}

