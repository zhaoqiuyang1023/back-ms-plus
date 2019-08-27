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

    @Autowired
    private SysUserRoleService sysUserRoleService;


    @Autowired
    private SysMenuService sysMenuService;


//    @GetMapping("/edit")
//    public String index(Model model) {
//        Subject s = SecurityUtils.getSubject();
//        SysUser sysUser = (SysUser) s.getPrincipal();
//        model.addAttribute("user", sysUser);
//        model.addAttribute("allRoles", sysRoleService.list());
//        return "admin/user/edit";
//    }

    @PostMapping("/save")
    @ResponseBody
    public RestResponse save(@RequestBody SysUser sysUser) {

        return sysUserService.saveSysUser(sysUser) ? RestResponse.success("修改成功") : RestResponse.failure("验证码超时");
    }

    @GetMapping("list")
    public String list() {
        return "admin/user/list";
    }

    @PostMapping("list")
    @ResponseBody
    public LayerData<SysUser> list(@RequestParam(value = "page", defaultValue = "1") Integer page,
                                   @RequestParam(value = "limit", defaultValue = "10") Integer limit,
                                   ServletRequest request) {
        Map map = WebUtils.getParametersStartingWith(request, "s_");
        LayerData<SysUser> userLayerData = new LayerData<>();
        QueryWrapper<SysUser> userEntityWrapper = new QueryWrapper<>();
        if (!map.isEmpty()) {
            String keys = (String) map.get("key");
            if (StringUtils.isNotBlank(keys)) {
                userEntityWrapper.like("login_name", keys).or().like("tel", keys).or().like("email", keys);
            }
        }
        userEntityWrapper.orderByDesc("update_date");
        IPage<SysUser> userPage = sysUserService.page(new Page<>(page, limit), userEntityWrapper);
        userLayerData.setCount(userPage.getTotal());
        userLayerData.setData(userPage.getRecords());
        return userLayerData;
    }

    @GetMapping("add")
    public String add(Model model) {
        List<SysRole> roleList = sysRoleService.list();
        model.addAttribute("roles", roleList);
        return "admin/user/add";
    }

    @RequiresPermissions("admin:user:add")
    @PostMapping("add")
    @ResponseBody
    public RestResponse add(@RequestBody SysUser user) {
        if (StringUtils.isBlank(user.getLoginName())) {
            return RestResponse.failure("登录名不能为空");
        }
        if (user.getSysRoles() == null || user.getSysRoles().size() == 0) {
            return RestResponse.failure("用户角色至少选择一个");
        }
        if (sysUserService.count(new QueryWrapper<SysUser>().eq("login_name", user.getLoginName())) > 0) {
            return RestResponse.failure("登录名称已经存在");
        }
        if (StringUtils.isNotBlank(user.getEmail())) {
            if (sysUserService.count(new QueryWrapper<SysUser>().eq("email", user.getEmail())) > 0) {
                return RestResponse.failure("该邮箱已被使用");
            }
        }
        if (StringUtils.isNoneBlank(user.getTel())) {
            if (sysUserService.count(new QueryWrapper<SysUser>().eq("tel", user.getTel())) > 0) {
                return RestResponse.failure("该手机号已被绑定");
            }
        }
        user.setPassword(Constants.DEFAULT_PASSWORD);
        sysUserService.saveUser(user);
        if (user.getId() == null || user.getId() == 0) {
            return RestResponse.failure("保存用户信息出错");
        }
        return RestResponse.success();
    }

    @GetMapping("edit")
    public String edit(Long id, Model model) {
        SysUser user = sysUserService.findUserById(id);
        model.addAttribute("user", user);
        model.addAttribute("allRoles", sysRoleService.list());
        return "admin/user/edit";
    }
//
//    @RequiresPermissions("admin:user:edit")
//    @PostMapping("edit")
//    @ResponseBody
//    public RestResponse edit(@RequestBody SysUser user) {
//        if (user.getId() == 0 || user.getId() == null) {
//            return RestResponse.failure("用户ID不能为空");
//        }
//        if (StringUtils.isBlank(user.getLoginName())) {
//            return RestResponse.failure("登录名不能为空");
//        }
//        if (user.getSysRoles() == null || user.getSysRoles().size() == 0) {
//            return RestResponse.failure("用户角色至少选择一个");
//        }
//        SysUser oldUser = sysUserService.findUserById(user.getId());
//        if (StringUtils.isNotBlank(user.getEmail())) {
//            if (!user.getEmail().equals(oldUser.getEmail())) {
//                if (sysUserService.userCount(user.getEmail()) > 0) {
//                    return RestResponse.failure("该邮箱已被使用");
//                }
//            }
//        }
//        if (StringUtils.isNotBlank(user.getLoginName())) {
//            if (!user.getLoginName().equals(oldUser.getLoginName())) {
//                if (sysUserService.userCount(user.getLoginName()) > 0) {
//                    return RestResponse.failure("该登录名已存在");
//                }
//            }
//        }
//        if (StringUtils.isNotBlank(user.getTel())) {
//            if (!user.getTel().equals(oldUser.getTel())) {
//                if (sysUserService.userCount(user.getTel()) > 0) {
//                    return RestResponse.failure("该手机号已经被绑定");
//                }
//            }
//        }
//        user.setIcon(oldUser.getIcon());
//        sysUserService.updateUser(user);
//        return RestResponse.success();
//    }

    @RequiresPermissions("admin:user:delete")
    @PostMapping("delete")
    @ResponseBody
    public RestResponse delete(@RequestParam(value = "id", required = false) Long id) {
        if (id == null || id == 0) {
            return RestResponse.failure("用户ID参数错误");
        }
        if (id == 1) {
            return RestResponse.failure("不能停用超级管理员");
        }
        SysUser user = sysUserService.getById(id);
        if (user == null) {
            return RestResponse.failure("用户不存在");
        }
        sysUserService.deleteUser(user);
        return RestResponse.success();
    }

    @RequiresPermissions("admin:user:delete")
    @PostMapping("deleteSome")
    @ResponseBody
    //@SysLog("停用系统用户数据(多个)")
    public RestResponse deleteSome(@RequestBody List<SysUser> users) {
        if (users == null || users.size() == 0) {
            return RestResponse.failure("请选择需要停用的用户");
        }
        for (SysUser u : users) {
            if (u.getId() == 1) {
                return RestResponse.failure("不能停用超级管理员");
            } else {
                sysUserService.deleteUser(u);
            }
        }
        return RestResponse.success();
    }

    /***
     * 获得用户所拥有的菜单列表
     * @return
     */
    @GetMapping("getUserMenu")
    @ResponseBody
    public List<ShowMenu> getUserMenu() {
        Subject s = SecurityUtils.getSubject();
        SysUser sysUser = (SysUser) s.getPrincipal();
        List<ShowMenu> list = sysMenuService.getShowMenuByUser(sysUser.getId());
        return list;
    }


    @PostMapping("saveUserinfo")
    @ResponseBody
    public RestResponse saveUserInfo(SysUser user) {
        if (user.getId() == 0 || user.getId() == null) {
            return RestResponse.failure("用户ID不能为空");
        }
        if (StringUtils.isBlank(user.getLoginName())) {
            return RestResponse.failure("登录名不能为空");
        }
        SysUser oldUser = sysUserService.findUserById(user.getId());
        if (StringUtils.isNotBlank(user.getEmail())) {
            if (!user.getEmail().equals(oldUser.getEmail())) {
                if (sysUserService.count(new QueryWrapper<SysUser>().eq("email", user.getEmail())) > 0) {
                    return RestResponse.failure("该邮箱已被使用");
                }
            }
        }
        if (StringUtils.isNotBlank(user.getTel())) {
            if (!user.getTel().equals(oldUser.getTel())) {
                if (sysUserService.count(new QueryWrapper<SysUser>().eq("tel", user.getTel())) > 0) {
                    return RestResponse.failure("该手机号已经被绑定");
                }
            }
        }
        user.setSysRoles(oldUser.getSysRoles());
        sysUserService.updateUser(user);
        return RestResponse.success();
    }

    @GetMapping("changePassword")
    public String changePassword() {
        return "admin/system/user/changePassword";
    }

    @RequiresPermissions("admin:user:changePassword")
    @PostMapping("changePassword")
    @ResponseBody
    public RestResponse changePassword(@RequestParam(value = "oldPwd", required = false) String oldPwd,
                                       @RequestParam(value = "newPwd", required = false) String newPwd,
                                       @RequestParam(value = "confirmPwd", required = false) String confirmPwd) {
        if (StringUtils.isBlank(oldPwd)) {
            return RestResponse.failure("旧密码不能为空");
        }
        if (StringUtils.isBlank(newPwd)) {
            return RestResponse.failure("新密码不能为空");
        }
        if (StringUtils.isBlank(confirmPwd)) {
            return RestResponse.failure("确认密码不能为空");
        }
        if (!confirmPwd.equals(newPwd)) {
            return RestResponse.failure("确认密码与新密码不一致");
        }
        Subject s = SecurityUtils.getSubject();
        SysUser sysUser = (SysUser) s.getPrincipal();
        SysUser user = sysUserService.getById(sysUser.getId());

        //旧密码不能为空
        //  String pw = ToolUtil.entryptPassword(oldPwd,user.getSalt()).split(",")[0];
//        if(!user.getPassword().equals(pw)){
//            return RestResponse.failure("旧密码错误");
//        }
        user.setPassword(newPwd);
        //  ToolUtil.entryptPassword(user);
        sysUserService.updateById(user);
        return RestResponse.success();
    }


}
