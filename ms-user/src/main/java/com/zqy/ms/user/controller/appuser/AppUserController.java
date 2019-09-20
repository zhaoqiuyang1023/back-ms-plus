package com.zqy.ms.user.controller.appuser;

import java.util.*;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.zqy.ms.user.entity.Organization;
import com.zqy.ms.user.entity.User;
import com.zqy.ms.user.entity.ao.RegisterAO;
import com.zqy.ms.user.util.LayerData;
import com.zqy.ms.user.util.RestResponse;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.*;

import com.zqy.ms.user.service.UserService;

import javax.servlet.ServletRequest;


/**
 * @author @Alan
 * @date 2019-09-20 22:46:12
 */
@Controller
@RequestMapping("/appUser")
public class AppUserController {

    @Autowired
    private UserService userService;


    @GetMapping("list")
    public String list() {
        return "appuser/list";
    }

    @PostMapping("list")
    @ResponseBody
    public LayerData<User> list(@RequestParam(value = "page", defaultValue = "1") Integer page,
                                @RequestParam(value = "limit", defaultValue = "10") Integer limit,
                                ServletRequest request) {
        LayerData<User> userLayerData = new LayerData<>();
        String name = request.getParameter("name");
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        if (StringUtils.isNotBlank(name)) {
            queryWrapper.like("name", name);
        }
        queryWrapper.orderByDesc("update_date");
        IPage<User> userPage = userService.page(new Page<>(page, limit), queryWrapper);
        userLayerData.setCount(userPage.getTotal());
        userLayerData.setData(userPage.getRecords());
        return userLayerData;
    }

    @GetMapping("/add")
    public String add(Model model) {

        return "appuser/add";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") String id, Model model) {

        User user = userService.getById(id);
        model.addAttribute("user", user);
        return "appuser/edit";
    }


    @PostMapping("register")
    @ResponseBody
    public RestResponse add(@RequestBody RegisterAO registerAo) {
        if (StringUtils.isBlank(registerAo.getUsername())) {
            return RestResponse.failure("名称不能为空");
        }
        User existRole = userService.getOne(new QueryWrapper<User>().eq("username", registerAo.getUsername()));
        if (existRole != null) {
            return RestResponse.failure("操作失败用户名已存在");
        }
        Organization organization=new Organization();
        BeanUtils.copyProperties(registerAo,organization);
        organization.setUpdateDate(new Date());
        organization.setCreateDate(new Date());
        organization.setName(registerAo.getOrganizationName());
        organization.insert();

        User user = new User();
        String salt = "123456";
        String passwork = "123456";
        user.setSalt(salt);
        String md5Password = DigestUtils.md5DigestAsHex((passwork + salt).getBytes());
        BeanUtils.copyProperties(registerAo, user);
        user.setUpdateDate(new Date());
        user.setPassword(md5Password);
        user.setOrganizationId(organization.getId());
        userService.save(user);
        return RestResponse.success("操作成功");
    }

    @PostMapping("update")
    @ResponseBody
    public RestResponse update(@RequestBody RegisterAO registerAo) {
        if (StringUtils.isBlank(registerAo.getUsername())) {
            return RestResponse.failure("角色名称不能为空");
        }
        User existRole = userService.getOne(new QueryWrapper<User>().eq("username", registerAo.getUsername()));
        if (existRole != null) {
            if (!existRole.getId().equals(registerAo.getId())) {
                return RestResponse.failure("操作失败用户名已存在");
            }
        }
        Organization organization=new Organization();
        BeanUtils.copyProperties(registerAo,organization);
        organization.setUpdateDate(new Date());
        organization.setCreateDate(new Date());
        organization.setName(registerAo.getOrganizationName());
        User user = userService.getById(registerAo.getId());
        user.setAdmin(true);
        BeanUtils.copyProperties(registerAo, user);
        user.setUpdateDate(new Date());
        userService.updateById(user);
        return RestResponse.success("操作成功");
    }


    @PostMapping("delete")
    @ResponseBody
    public RestResponse delete(@RequestParam(value = "id", required = false) String id) {
        userService.removeById(id);

        return RestResponse.success("操作成功");
    }

}
