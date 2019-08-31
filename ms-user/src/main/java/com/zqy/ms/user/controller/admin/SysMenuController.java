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
    public LayerData<SysMenu>  list() {
        LayerData<SysMenu> menus = new LayerData<>();
        List<SysMenu> sysMenus= sysMenuService.list();
        menus.setCount((long) sysMenus.size());
        menus.setData(sysMenus);
        return menus;
    }

    @ApiOperation(value = "跳转到添加子菜单页面")
    @GetMapping("/addChild/{parentId}")
    public String addChildMenuByParentId(@PathVariable(value = "parentId") Long id,Model model) {
        SysMenu parentMenu = sysMenuService.getById(id);
        model.addAttribute("parentMenu",parentMenu);
        return "admin/menu/addChild";
    }

    @ApiOperation(value = "跳转到添加父级菜单页面")
    @GetMapping("/addParent")
    public String addParentMenu() {
        return "admin/menu/addparent";
    }

    @ApiOperation(value = "跳转到编辑菜单")
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable(value = "id") Long id,Model model) {
        SysMenu selfMenu = sysMenuService.getById(id);
        model.addAttribute("menu",selfMenu);

        model.addAttribute("parentMenu",sysMenuService.getById(selfMenu.getParentId()));
        return "admin/menu/edit";
    }


    @ApiOperation(value = "保存菜单")
    @PostMapping("/save")
    @ResponseBody
    public RestResponse save(SysMenu sysMenu) {
        Log.i(sysMenu);
        if(StringUtils.isEmpty(sysMenu.getParentId())){
            sysMenu.setParentId(0L);
        }
        sysMenuService.saveOrUpdate(sysMenu);
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
