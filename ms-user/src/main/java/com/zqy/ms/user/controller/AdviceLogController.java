package com.zqy.ms.user.controller;

import java.util.Arrays;
import java.util.Map;

import java.util.Arrays;
import java.util.Map;

import com.zqy.ms.user.util.LayerData;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.zqy.ms.user.util.RestResponse;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.zqy.ms.user.entity.AdviceLog;
import com.zqy.ms.user.service.AdviceLogService;

import javax.servlet.ServletRequest;


/**
 * 
 *
 * @author Alan
 * @date 2019-10-18 21:06:50
 */
@Controller
@RequestMapping("/advicelog")
public class AdviceLogController {
    @Autowired
    private AdviceLogService adviceLogService;


    @GetMapping("list")
    public String list() {
        return "advicelog/list";

    }

    @PostMapping("list")
    @ResponseBody
    public LayerData<AdviceLog> list(@RequestParam(value = "page", defaultValue = "1") Integer page,
                                   @RequestParam(value = "limit", defaultValue = "10") Integer limit,
                                   ServletRequest request) {
        LayerData<AdviceLog> layerData = new LayerData<>();
        QueryWrapper<AdviceLog> queryWrapper = new QueryWrapper<>();
        queryWrapper.orderByDesc("create_date");
        IPage<AdviceLog> userPage = adviceLogService.page(new Page<>(page, limit), queryWrapper);
        layerData.setCount(userPage.getTotal());
        layerData.setData(userPage.getRecords());
        return layerData;
    }





    @PostMapping("delete")
    @ResponseBody
    public RestResponse delete(@RequestParam(value = "id", required = false) String id) {
            adviceLogService.removeById(id);
        return RestResponse.success("操作成功");
    }




}
