package com.zqy.ms.user.controller.user;

import com.zqy.ms.user.entity.SysUser;
import com.zqy.ms.user.service.SysRoleService;
import com.zqy.ms.user.service.SysUserService;
import com.zqy.ms.user.util.Log;
import com.zqy.ms.user.util.RestResponse;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


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



    @ApiOperation(value = "修改")
    @PostMapping("/save")
    @ResponseBody
    public RestResponse save(SysUser sysUser) {
        Log.i(sysUser);
        if(sysUser==null){
           return RestResponse.failure("用户不能为空");
        }
        return sysUserService.updateById(sysUser) ? RestResponse.success("修改成功") : RestResponse.failure("验证码超时");
    }


    @ApiOperation(value = "跳转到页面编辑界面")
    @GetMapping("edit")
    public String edit(Model model) {
        SysUser sysUser =  (SysUser) SecurityUtils.getSubject().getPrincipal();
        SysUser user = sysUserService.findUserById(sysUser.getId());
        Log.i(user.getSysMenus());
        model.addAttribute("userinfo", user);
        return "user/userInfo";
    }
}
