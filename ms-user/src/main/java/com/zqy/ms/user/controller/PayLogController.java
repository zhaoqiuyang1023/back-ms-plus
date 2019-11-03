package com.zqy.ms.user.controller;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Map;

import java.util.Arrays;
import java.util.Map;

import com.zqy.ms.user.entity.Organization;
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
import com.zqy.ms.user.entity.PayLog;
import com.zqy.ms.user.service.PayLogService;

import javax.servlet.ServletRequest;


/**
 * 
 *
 * @author Alan
 * @date 2019-11-01 20:35:15
 */
@Controller
@RequestMapping("/paylog")
public class PayLogController {

    @Autowired
    private PayLogService payLogService;


    @GetMapping("list")
    public String list() {
        return "paylog/list";

    }

    @PostMapping("list")
    @ResponseBody
    public LayerData<PayLog> list(@RequestParam(value = "page", defaultValue = "1") Integer page,
                                   @RequestParam(value = "limit", defaultValue = "10") Integer limit,
                                   ServletRequest request) {
        LayerData<PayLog> layerData = new LayerData<>();
        QueryWrapper<PayLog> queryWrapper = new QueryWrapper<>();
        String name = request.getParameter("name");
        String beginDate = request.getParameter("beginDate");
        String endDate = request.getParameter("endDate");
        if (StringUtils.isNotBlank(name)) {
            queryWrapper.like("organization_name", name).or().like("user_name",name).or().like("trade_no",name);
        }
        if (StringUtils.isNotBlank(beginDate)) {
            String endDateMax= DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").format(LocalDateTime.of(LocalDate.parse(endDate.trim()), LocalTime.MAX));
            queryWrapper.between("create_date", beginDate, endDateMax);
        }
        queryWrapper.orderByDesc("create_date");
        IPage<PayLog> userPage = payLogService.page(new Page<>(page, limit), queryWrapper);
        layerData.setCount(userPage.getTotal());
        layerData.setData(userPage.getRecords());
        return layerData;
    }

    @PostMapping("delete")
    @ResponseBody
    public RestResponse delete(@RequestParam(value = "id", required = false) String id) {
        payLogService.removeById(id);
        return RestResponse.success("操作成功");
    }
}
