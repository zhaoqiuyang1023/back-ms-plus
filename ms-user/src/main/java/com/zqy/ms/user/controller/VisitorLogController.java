package com.zqy.ms.user.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zqy.ms.user.entity.VisitorLog;
import com.zqy.ms.user.util.LayerData;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;


/**
 * @author alan
 * 2019-07-12 10:57:26
 */
@Controller
@RequestMapping("/visitor")
public class VisitorLogController {

    @Autowired
    private com.zqy.ms.user.service.VisitorLogService VisitorLogService;


    @GetMapping("/list")
    public String list() {
        return "visitorlog/list";
    }

    @PostMapping("/list")
    @ResponseBody
    public LayerData<VisitorLog> list(VisitorLog visitorLog) {
        Page<VisitorLog> pagee = new Page<>(visitorLog.getPage(), visitorLog.getLimit());
        QueryWrapper<VisitorLog> entityWrapper = new QueryWrapper<>();
        if(StringUtils.isNotEmpty(visitorLog.getBeginTime())){
            entityWrapper.between("date_create", visitorLog.getBeginTime(), visitorLog.getEndTime());
        }
        if(visitorLog.getUsername()!=null){
            entityWrapper.like("username",visitorLog.getUsername());
        }
        IPage<VisitorLog> page = VisitorLogService.page(pagee, entityWrapper);
        LayerData<VisitorLog> layerData = new LayerData<>();
        List<VisitorLog> newsSettings = page.getRecords();
        layerData.setData(newsSettings);
        layerData.setCount(page.getTotal());
        return layerData;
    }


}
