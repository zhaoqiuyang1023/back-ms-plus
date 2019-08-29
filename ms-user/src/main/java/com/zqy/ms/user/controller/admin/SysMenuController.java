package com.zqy.ms.user.controller.admin;

import com.zqy.ms.user.entity.SysMenu;
import com.zqy.ms.user.service.SysMenuService;
import com.zqy.ms.user.util.LayerData;
import com.zqy.ms.user.util.Log;
import com.zqy.ms.user.util.RestResponse;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;


/**
 * @author Alan
 * @date 2019-08-29 17:51:37
 */
@CrossOrigin
@Controller
@RequestMapping("/admin/menu")
public class SysMenuController {
    @Autowired
    private SysMenuService sysMenuService;

    @GetMapping("list")
    public String index() {
        return "admin/menu/list";
    }

    @GetMapping("data")
    @ResponseBody
    public LayerData<SysMenu>  list() {
        LayerData<SysMenu> menus = new LayerData<>();
        List<SysMenu> sysMenus= sysMenuService.list();
        menus.setCount((long) sysMenus.size());
        menus.setData(sysMenus);
        return menus;
    }

    @ApiOperation(value = "添加子菜单")
    @GetMapping("/addChild/{parentId}")
    public String addChildMenuByParentId(@PathVariable(value = "parentId") Long id,Model model) {
        SysMenu parentMenu = sysMenuService.getById(id);
        model.addAttribute("parentMenu",parentMenu);
        return "admin/menu/addChild";
    }

    @ApiOperation(value = "添加顶级菜单")
    @GetMapping("/addParent")
    public String addParentMenu() {
        return "admin/menu/addparent";
    }

    @ApiOperation(value = "编辑菜单")
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable(value = "id") Long id,Model model) {
        SysMenu menu = sysMenuService.getById(id);
        model.addAttribute("menu",menu);
        return "admin/menu/edit";
    }


    @ApiOperation(value = "保存菜单")
    @PostMapping("/save")
    @ResponseBody
    public RestResponse save(SysMenu sysMenu) {
        Log.i(sysMenu);
        sysMenuService.save(sysMenu);
        return RestResponse.success();
    }


    @ApiOperation(value = "删除菜单")
    @ResponseBody
    @PostMapping("/delete/{id}")
    public RestResponse delete(@PathVariable("id") Long id) {
        sysMenuService.removeById(id);
        return RestResponse.success();
    }

}
