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
import com.zqy.ms.user.mapper.OrganizationMapper;
import com.zqy.ms.user.entity.Organization;
import com.zqy.ms.user.service.OrganizationService;
import java.util.List;

/**
 * 
 * @author @Alan
 * @date 2019-09-20 21:56:51
 */
@Service("organizationService")
public class OrganizationServiceImpl extends ServiceImpl<OrganizationMapper, Organization> implements OrganizationService {

    @Autowired
    private OrganizationMapper organizationMapper;

    @Override
    public List<Organization> getOrganizationListByPage(Page page, @Param("param") Map<String, Object> map) {
        return organizationMapper.getOrganizationListByPage(page, map);
    }
}
