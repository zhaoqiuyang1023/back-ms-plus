package com.zqy.ms.user.controller.admin;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.additional.query.impl.QueryChainWrapper;
import com.zqy.ms.user.entity.SysMenu;
import com.zqy.ms.user.entity.SysRole;
import com.zqy.ms.user.entity.SysRoleMenu;
import com.zqy.ms.user.entity.SysUserRole;
import com.zqy.ms.user.service.SysMenuService;
import com.zqy.ms.user.service.SysRoleMenuService;
import com.zqy.ms.user.service.SysRoleService;
import com.zqy.ms.user.service.SysUserRoleService;
import com.zqy.ms.user.util.LayerData;
import com.zqy.ms.user.util.Log;
import com.zqy.ms.user.util.RestResponse;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletRequest;
import java.util.Date;
import java.util.List;


/**
 * @author Alan
 * @date 2019-08-01 10:54:19
 */
@Controller
@Slf4j
@RequestMapping("/admin/role")
public class SysRoleController {
    @Autowired
    private SysRoleService sysRoleService;

    @Autowired
    private SysMenuService sysMenuService;


    @GetMapping("list")
    public String list() {
        return "admin/role/list";
    }

    @PostMapping("list")
    @ResponseBody
    public LayerData<SysRole> list(@RequestParam(value = "page", defaultValue = "1") Integer page,
                                   @RequestParam(value = "limit", defaultValue = "10") Integer limit,
                                   ServletRequest request) {
        LayerData<SysRole> userLayerData = new LayerData<>();
        QueryWrapper<SysRole> userEntityWrapper = new QueryWrapper<>();

        userEntityWrapper.orderByDesc("update_date");
        IPage<SysRole> userPage = sysRoleService.page(new Page<>(page, limit), userEntityWrapper);
        userLayerData.setCount(userPage.getTotal());
        userLayerData.setData(userPage.getRecords());
        return userLayerData;
    }

    @GetMapping("/add")
    public String add(Model model) {
        model.addAttribute("menus", sysMenuService.findAllTreeMenus());
        return "admin/role/add";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, Model model) {
        model.addAttribute("menus", sysMenuService.findAllTreeMenus());
        Log.i(sysMenuService.findAllTreeMenus());
        SysRole sysRole = sysRoleService.getById(id);
        List<SysMenu> sysMenus = sysMenuService.findAllMenusByRoleId(id);
        Log.i("角色菜单"+sysMenus);
        sysRole.setSysMenus(sysMenus);
        model.addAttribute("sysRole", sysRole);
        return "admin/role/edit";
    }



    @PostMapping("save")
    @ResponseBody
    public RestResponse add(@RequestBody SysRole role) {
        log.info(""+role);
        if (StringUtils.isBlank(role.getName())) {
            return RestResponse.failure("角色名称不能为空");
        }
        SysRole existRole = sysRoleService.getOne(new QueryWrapper<SysRole>().eq("name", role.getName()));
        if (existRole != null) {
            //如是修改
            if (role.getId() != null && role.getId() != 0) {
                //两条角色的id不一样
                if (!existRole.getId().equals(role.getId())) {
                    return RestResponse.failure("角色名称已存在");
                }
            }
        }
        role.setUpdateDate(new Date());
        sysRoleService.saveRole(role);
        return RestResponse.success("操作成功");
    }




    @PostMapping("delete")
    @ResponseBody
    public RestResponse delete(@RequestParam(value = "id", required = false) Long id) {
        if (id == null || id == 0) {
            return RestResponse.failure("角色ID不能为空");
        }
        sysRoleService.deleteRoleByRoleId(id);

        return RestResponse.success("操作成功");
    }

}
