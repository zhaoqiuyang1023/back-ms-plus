package com.zqy.ms.user.controller.admin;

import com.zqy.ms.user.entity.SysMenu;
import com.zqy.ms.user.entity.SysUser;
import com.zqy.ms.user.service.SysMenuService;
import com.zqy.ms.user.util.LayerData;
import com.zqy.ms.user.util.Log;
import com.zqy.ms.user.util.RestResponse;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

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


    @ApiOperation(value = "跳转到列表页")
    @GetMapping("list")
    public String index() {
        return "admin/menu/list";
    }

    @ApiOperation(value = "获取递归信息数据")
    @GetMapping("data")
    @ResponseBody
    public LayerData<SysMenu> list() {
        LayerData<SysMenu> menus = new LayerData<>();
        List<SysMenu> sysMenus = sysMenuService.list();
        menus.setCount((long) sysMenus.size());
        menus.setData(sysMenus);
        return menus;
    }

    @ApiOperation(value = "跳转到添加子菜单页面")
    @GetMapping("/addChild/{parentId}")
    public String addChildMenuByParentId(@PathVariable(value = "parentId") Long id, Model model) {
        SysMenu parentMenu = sysMenuService.getById(id);
        model.addAttribute("parentMenu", parentMenu);
        return "admin/menu/addChild";
    }

    @ApiOperation(value = "添加子菜单页面")
    @PostMapping("/addChild")
    @ResponseBody
    public RestResponse addChild(SysMenu childSysMenu) {
        Log.i(childSysMenu);
        if (StringUtils.isEmpty(childSysMenu.getParentId())) {
            return RestResponse.failure("父菜单不能为空");
        }
        SysMenu parentMenu = sysMenuService.getById(childSysMenu.getParentId());
        if (parentMenu == null) {
            return RestResponse.failure("父菜单不存在");
        }
        if (StringUtils.isEmpty(parentMenu.getLevel())) {
            return RestResponse.failure("父菜单等级不能为空");
        }
        Long level = parentMenu.getLevel() + 1;
        SysUser currentSysUser = (SysUser) SecurityUtils.getSubject().getPrincipal();
        childSysMenu.setCreateBy(currentSysUser.getId());
        childSysMenu.setLevel(level);
        sysMenuService.save(childSysMenu);
        return RestResponse.success("添加成功");
    }

    @ApiOperation(value = "跳转到添加父级菜单页面")
    @GetMapping("/addParent")
    public String addParentMenu() {
        return "admin/menu/addparent";
    }
    @ApiOperation(value = "跳转到添加父级菜单页面")
    @PostMapping("/addParent")
    @ResponseBody
    public RestResponse addParentMenu(SysMenu parentSysMenu) {
        parentSysMenu.setParentId(0L);
        parentSysMenu.setLevel(1L);
        Subject s = SecurityUtils.getSubject();
        SysUser currentSysUser = (SysUser) s.getPrincipal();
        parentSysMenu.setCreateBy(currentSysUser.getId());
        sysMenuService.save(parentSysMenu);
        return RestResponse.success("添加成功");
    }

    @ApiOperation(value = "跳转到编辑菜单")
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable(value = "id") Long id, Model model) {
        SysMenu selfMenu = sysMenuService.getById(id);
        model.addAttribute("menu", selfMenu);
        model.addAttribute("parentMenu", sysMenuService.getById(selfMenu.getParentId()));
        return "admin/menu/edit";
    }

    @ApiOperation(value = "保存菜单")
    @PostMapping("/save")
    @ResponseBody
    public RestResponse save(SysMenu sysMenu) {
        SysUser currentSysUser = (SysUser) SecurityUtils.getSubject().getPrincipal();
        sysMenu.setUpdateBy(currentSysUser.getId());
        sysMenuService.updateById(sysMenu);
        return RestResponse.success();
    }


    @ApiOperation(value = "删除菜单")
    @ResponseBody
    @PostMapping("/delete/{id}")
    public RestResponse delete(@PathVariable("id") Long id) {
        sysMenuService.removeById(id);
        return RestResponse.success("删除菜单成功");
    }

}
