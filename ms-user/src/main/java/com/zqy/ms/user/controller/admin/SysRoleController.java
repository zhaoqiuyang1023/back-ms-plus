package com.zqy.ms.user.controller.admin;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zqy.ms.user.entity.SysRole;
import com.zqy.ms.user.service.SysMenuService;
import com.zqy.ms.user.service.SysRoleService;
import com.zqy.ms.user.util.LayerData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletRequest;


/**
 * 
 *
 * @author Alan
 * @date 2019-08-01 10:54:19
 */
@Controller
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
    public String add(Model model){
        model.addAttribute("menus",sysMenuService.findAllMenusByLevel());
        return "admin/role/add";
    }

}
