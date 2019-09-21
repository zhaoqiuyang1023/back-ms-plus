package com.zqy.ms.user.service;
import org.apache.ibatis.annotations.Param;
import java.util.Map;
import com.baomidou.mybatisplus.extension.service.IService;
import com.zqy.ms.user.entity.AppVersion;
import org.apache.ibatis.annotations.Param;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import java.util.List;
/**
 * 
 * @author @Alan
 * @date 2019-09-21 10:44:38
 */
public interface AppVersionService extends IService<AppVersion> {

    List<AppVersion> getAppVersionListByPage(Page page, @Param("param") Map<String, Object> map);
}

