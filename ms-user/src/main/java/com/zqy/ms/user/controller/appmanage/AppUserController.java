package com.zqy.ms.user.controller.appmanage;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zqy.ms.user.entity.Organization;
import com.zqy.ms.user.entity.User;
import com.zqy.ms.user.entity.ao.BasePageAO;
import com.zqy.ms.user.entity.ao.RegisterAO;
import com.zqy.ms.user.entity.vo.UserVO;
import com.zqy.ms.user.service.OrganizationService;
import com.zqy.ms.user.service.UserService;
import com.zqy.ms.user.util.LayerData;
import com.zqy.ms.user.util.PasswordEncoderUtils;
import com.zqy.ms.user.util.RestResponse;
import io.swagger.annotations.Api;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.Date;
import java.util.List;


/**
 * @author @Alan
 * @date 2019-09-20 22:46:12
 */
@Controller
@Api(tags = "app用户管理")
@RequestMapping("/appUser")
public class AppUserController {

    @Autowired
    private UserService userService;

    @Autowired
    private OrganizationService organizationService;


    @GetMapping("list")
    public String list() {
        return "appuser/list";
    }

    @PostMapping("list")
    @ResponseBody
    public LayerData<User> list(BasePageAO basePageAo) {
        LayerData<User> userLayerData = new LayerData<>();
        String beginDate = basePageAo.getBeginDate();
        String endDate = basePageAo.getEndDate();
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        if (StringUtils.isNotBlank(basePageAo.getName())) {
            queryWrapper.like("username", basePageAo.getName()).or().like("tel", basePageAo.getName());
        }
        if(StringUtils.isNotBlank(beginDate)){
            queryWrapper.between("create_date", beginDate,endDate);
        }
        queryWrapper.orderByDesc("update_date");
        IPage<User> userPage = userService.page(new Page<>(basePageAo.getPage(), basePageAo.getLimit()), queryWrapper);
        List<User> users = userPage.getRecords();
        for (User user : users) {
            Organization organization = organizationService.getById(user.getOrganizationId());
            if (organization != null) {
                user.setOrganizationName(organization.getName());
            }
        }
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


        Organization organization = organizationService.getById(user.getOrganizationId());
        model.addAttribute("user", user);
        model.addAttribute("organization", organization);
        return "appuser/edit";
    }


    @PostMapping("register")
    @ResponseBody
    public RestResponse add(@RequestBody RegisterAO registerAo) {
        if (StringUtils.isBlank(registerAo.getTel())) {
            return RestResponse.failure("手机号不能为空");
        }
        if (StringUtils.isBlank(registerAo.getUsername())) {
            return RestResponse.failure("名称不能为空");
        }
        User existRole = userService.getOne(new QueryWrapper<User>().eq("tel", registerAo.getUsername()));
        if (existRole != null) {
            return RestResponse.failure("手机号已经存在");
        }
        Organization organization = new Organization();
        BeanUtils.copyProperties(registerAo, organization);
        organization.setUpdateDate(new Date());
        organization.setCreateDate(new Date());
        organization.setName(registerAo.getOrganizationName());
        organization.insert();

        User user = new User();

        String bCryptPassword = PasswordEncoderUtils.encode("123456");
        BeanUtils.copyProperties(registerAo, user);
        user.setUpdateDate(new Date());
        user.setPassword(bCryptPassword);
        user.setOrganizationId(organization.getId());
        userService.save(user);
        return RestResponse.success("操作成功");
    }

    @PostMapping("update")
    @ResponseBody
    public RestResponse update(@RequestBody RegisterAO registerAo) {
        if (StringUtils.isBlank(registerAo.getUsername())) {
            return RestResponse.failure("名称不能为空");
        }
        User existRole = userService.getOne(new QueryWrapper<User>().eq("tel", registerAo.getTel()));
        if (existRole != null) {
            if (!existRole.getId().equals(registerAo.getId())) {
                return RestResponse.failure("操作失败手机号已存在");
            }
        }
        User user = userService.getById(registerAo.getId());
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
