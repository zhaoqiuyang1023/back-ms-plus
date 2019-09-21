package com.zqy.ms.user.controller.appmanage;

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
import com.zqy.ms.user.entity.AppVersion;
import com.zqy.ms.user.service.AppVersionService;

import javax.servlet.ServletRequest;


/**
 * @author @Alan
 * @date 2019-09-21 10:50:34
 */
@Controller
@RequestMapping("/appversion")
public class AppVersionController {
    @Autowired
    private AppVersionService appVersionService;


    @GetMapping("list")
    public String list() {
        return "appversion/list";
    }

    @PostMapping("list")
    @ResponseBody
    public LayerData<AppVersion> list(@RequestParam(value = "page", defaultValue = "1") Integer page, @RequestParam(value = "limit", defaultValue = "10") Integer limit, ServletRequest request) {
        LayerData<AppVersion> layerData = new LayerData<>();
        QueryWrapper<AppVersion> queryWrapper = new QueryWrapper<>();

        queryWrapper.orderByDesc("create_date");
        IPage<AppVersion> userPage = appVersionService.page(new Page<>(page, limit), queryWrapper);
        layerData.setCount(userPage.getTotal());
        layerData.setData(userPage.getRecords());
        return layerData;
    }

    @GetMapping("/add")
    public String add() {
        return "appversion/add";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") String id, Model model) {

        AppVersion appVersion = appVersionService.getById(id);
        model.addAttribute("appVersion", appVersion);
        return "appversion/edit";
    }

    @PostMapping("save")
    @ResponseBody
    public RestResponse add(@RequestBody AppVersion appVersion) {

        if (StringUtils.isBlank(appVersion.getAppVersionName())) {
            return RestResponse.failure("名称不能为空");
        }
        AppVersion existAppVersion = appVersionService.getOne(new QueryWrapper<AppVersion>().eq("name", appVersion.getAppVersionName()));
        if (existAppVersion != null) {
            //如是修改
            if (StringUtils.isNotBlank(existAppVersion.getId())) {
                //两条的id不一样
                if (!existAppVersion.getId().equals(appVersion.getId())) {
                    return RestResponse.failure("名称已存在");
                }
            }
            //如果是添加
            else {
                return RestResponse.failure("名称已存在");
            }
        }
        appVersionService.saveOrUpdate(appVersion);
        return RestResponse.success("操作成功");
    }

    @PostMapping("delete")
    @ResponseBody
    public RestResponse delete(@RequestParam(value = "id", required = false) String id) {
        appVersionService.removeById(id);
        return RestResponse.success("操作成功");
    }


}
