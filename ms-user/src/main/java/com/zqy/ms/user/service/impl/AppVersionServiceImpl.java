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
import com.zqy.ms.user.mapper.AppVersionMapper;
import com.zqy.ms.user.entity.AppVersion;
import com.zqy.ms.user.service.AppVersionService;
import java.util.List;

/**
 * 
 * @author @Alan
 * @date 2019-09-21 10:44:38
 */
@Service("appVersionService")
public class AppVersionServiceImpl extends ServiceImpl<AppVersionMapper, AppVersion> implements AppVersionService {

    @Autowired
    private AppVersionMapper appVersionMapper;

    @Override
    public List<AppVersion> getAppVersionListByPage(Page page, @Param("param") Map<String, Object> map) {
        return appVersionMapper.getAppVersionListByPage(page, map);
    }
}
