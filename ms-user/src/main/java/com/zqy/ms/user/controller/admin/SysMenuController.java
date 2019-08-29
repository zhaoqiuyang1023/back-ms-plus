package com.zqy.ms.user.controller.admin;

import com.zqy.ms.user.entity.SysMenu;
import com.zqy.ms.user.service.SysMenuService;
import com.zqy.ms.user.util.LayerData;
import com.zqy.ms.user.util.RestResponse;
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
    public String index(Model model) {

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


    /**
     * get single info
     *
     * @param id
     * @return R
     */
    @GetMapping("/add/{parentId}")
    public String addMenusByParentId(@PathVariable(value = "parentId", required = false) Long id) {
        SysMenu sysMenu = sysMenuService.getById(id);
        return "admin/menu/add";
    }


    /**
     * save
     *
     * @param sysMenu
     * @return R
     */
    @PostMapping("/save")
    public RestResponse save(@RequestBody SysMenu sysMenu) {
        sysMenuService.save(sysMenu);
        return RestResponse.success();
    }


    /**
     * delete
     *
     * @param ids
     * @return R
     */
    @DeleteMapping("/delete")
    public RestResponse delete(@RequestBody Long[] ids) {
        sysMenuService.removeByIds(Arrays.asList(ids));
        return RestResponse.success();
    }

}
