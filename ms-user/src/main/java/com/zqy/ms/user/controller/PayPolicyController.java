package com.zqy.ms.user.controller;

import java.util.*;

import java.util.Arrays;
import java.util.Map;

import com.zqy.ms.user.util.LayerData;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.zqy.ms.user.util.RestResponse;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.zqy.ms.user.entity.PayPolicy;
import com.zqy.ms.user.service.PayPolicyService;

import javax.servlet.ServletRequest;


/**
 * @author Alan
 * @date 2019-11-01 20:35:15
 */
@Controller
@Slf4j
@RequestMapping("/payPolicy")
public class PayPolicyController {

    @Autowired
    private PayPolicyService payPolicyService;


    @GetMapping("list")
    public String list() {
        return "paypolicy/list";

    }

    @PostMapping("list")
    @ResponseBody
    public LayerData<PayPolicy> list(@RequestParam(value = "page", defaultValue = "1") Integer page,
                                     @RequestParam(value = "limit", defaultValue = "10") Integer limit,
                                     ServletRequest request) {
        LayerData<PayPolicy> layerData = new LayerData<>();
        QueryWrapper<PayPolicy> queryWrapper = new QueryWrapper<>();

        queryWrapper.orderByDesc("create_date");
        IPage<PayPolicy> userPage = payPolicyService.page(new Page<>(page, limit), queryWrapper);
        layerData.setCount(userPage.getTotal());
        layerData.setData(userPage.getRecords());
        return layerData;
    }

    @GetMapping("/add")
    public String add(Model model) {
        return "paypolicy/add";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") String id, Model model) {
        PayPolicy payPolicy = payPolicyService.getById(id);
        model.addAttribute("payPolicy", payPolicy);
        return "paypolicy/edit";
    }

    @PostMapping("save")
    @ResponseBody
    public RestResponse add(@RequestBody PayPolicy payPolicy) {
        log.info("" + payPolicy);
        if (StringUtils.isBlank(payPolicy.getDuration())) {
            return RestResponse.failure("名称不能为空");
        }
        payPolicy.setUpdateDate(new Date());
        payPolicyService.saveOrUpdate(payPolicy);
        return RestResponse.success("操作成功");
    }

    @PostMapping("delete")
    @ResponseBody
    public RestResponse delete(@RequestParam(value = "id", required = false) String id) {
        payPolicyService.removeById(id);
        return RestResponse.success("操作成功");
    }


}
