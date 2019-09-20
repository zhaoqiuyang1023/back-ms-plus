package com.zqy.ms.user.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zqy.ms.user.entity.Permission;
import com.zqy.ms.user.service.PermissionService;
import com.zqy.ms.user.util.LayerData;
import com.zqy.ms.user.util.RestResponse;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletRequest;


/**
 * @author @Alan
 * @date 2019-09-20 20:49:27
 */
@Controller
@RequestMapping("/permission")
public class PermissionController {
    @Autowired
    private PermissionService permissionService;


    @GetMapping("list")
    public String list() {
        return "function/list";
    }

    @PostMapping("list")
    @ResponseBody
    public LayerData<Permission> list(@RequestParam(value = "page", defaultValue = "1") Integer page,
                                      @RequestParam(value = "limit", defaultValue = "10") Integer limit,
                                      ServletRequest request) {
        LayerData<Permission> userLayerData = new LayerData<>();
        String name = request.getParameter("name");
        QueryWrapper<Permission> queryWrapper = new QueryWrapper<>();
        if (StringUtils.isNotBlank(name)) {
            queryWrapper.like("name", name);
        }
        queryWrapper.orderByDesc("sort");
        IPage<Permission> userPage = permissionService.page(new Page<>(page, limit), queryWrapper);
        userLayerData.setCount(userPage.getTotal());
        userLayerData.setData(userPage.getRecords());
        return userLayerData;
    }

    @GetMapping("/add")
    public String add(Model model) {

        return "function/add";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") String id, Model model) {

        Permission permission = permissionService.getById(id);

        model.addAttribute("permission", permission);
        return "function/edit";
    }


    @PostMapping("save")
    @ResponseBody
    public RestResponse add(@RequestBody Permission permission) {
        if (StringUtils.isBlank(permission.getName())) {
            return RestResponse.failure("角色名称不能为空");
        }
        Permission existRole = permissionService.getOne(new QueryWrapper<Permission>().eq("name", permission.getName()));
        if (existRole != null) {
            //如是修改
            if (StringUtils.isNotBlank(permission.getId())) {
                //两条角色的id不一样
                if (!existRole.getId().equals(permission.getId())) {
                    return RestResponse.failure("名称已存在");
                }
            } else {
                return RestResponse.failure("名称已存在");
            }

        }
        permissionService.saveOrUpdate(permission);
        return RestResponse.success("操作成功");
    }


    @PostMapping("delete")
    @ResponseBody
    public RestResponse delete(@RequestParam(value = "id", required = false) String id) {

        permissionService.removeById(id);

        return RestResponse.success("操作成功");
    }

}
