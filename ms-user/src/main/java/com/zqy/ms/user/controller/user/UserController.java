package com.zqy.ms.user.controller.user;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zqy.ms.user.entity.SysRole;
import com.zqy.ms.user.entity.SysUser;
import com.zqy.ms.user.entity.vo.ShowMenu;
import com.zqy.ms.user.service.SysMenuService;
import com.zqy.ms.user.service.SysRoleService;
import com.zqy.ms.user.service.SysUserRoleService;
import com.zqy.ms.user.service.SysUserService;
import com.zqy.ms.user.util.Constants;
import com.zqy.ms.user.util.LayerData;
import com.zqy.ms.user.util.RestResponse;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.WebUtils;

import javax.servlet.ServletRequest;
import java.util.List;
import java.util.Map;


/**
 * @author Alan
 * @date 2019-08-01 10:54:19
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private SysUserService sysUserService;

    @Autowired
    private SysRoleService sysRoleService;



    @PostMapping("/save")
    @ResponseBody
    public RestResponse save(@RequestBody SysUser sysUser) {
        return sysUserService.updateById(sysUser) ? RestResponse.success("修改成功") : RestResponse.failure("验证码超时");
    }


    @GetMapping("edit")
    public String edit(Model model) {
        SysUser sysUser =  (SysUser) SecurityUtils.getSubject().getPrincipal();
        SysUser user = sysUserService.findUserById(sysUser.getId());
        model.addAttribute("user", user);
        model.addAttribute("allRoles", sysRoleService.list());
        return "user/edit";
    }



}
