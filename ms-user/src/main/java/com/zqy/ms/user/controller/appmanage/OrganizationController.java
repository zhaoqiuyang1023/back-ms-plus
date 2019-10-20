package com.zqy.ms.user.controller.appmanage;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zqy.ms.user.entity.Organization;
import com.zqy.ms.user.entity.User;
import com.zqy.ms.user.service.OrganizationService;
import com.zqy.ms.user.service.UserService;
import com.zqy.ms.user.util.LayerData;
import com.zqy.ms.user.util.RestResponse;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletRequest;
import java.util.Date;


/**
 * @author @Alan
 * @date 2019-09-20 21:56:51
 */
@Controller
@Slf4j
@Api(tags = "app公司管理")
@RequestMapping("/organization")
public class OrganizationController {
    @Autowired
    private OrganizationService organizationService;

    @Autowired
    private UserService userService;


    @GetMapping("list")
    public String list() {
        return "organization/list";
    }

    @PostMapping("list")
    @ResponseBody
    public LayerData<Organization> list(@RequestParam(value = "page", defaultValue = "1") Integer page,
                                        @RequestParam(value = "limit", defaultValue = "10") Integer limit,
                                        ServletRequest request) {
        LayerData<Organization> userLayerData = new LayerData<>();
        String name = request.getParameter("name");
        String beginDate = request.getParameter("beginDate");
        String endDate = request.getParameter("endDate");
        QueryWrapper<Organization> queryWrapper = new QueryWrapper<>();
        if (StringUtils.isNotBlank(name)) {
            queryWrapper.like("name", name);
        }
        if (StringUtils.isNotBlank(beginDate)) {
            queryWrapper.between("create_date", beginDate, endDate);
        }
        queryWrapper.orderByDesc("update_date");
        IPage<Organization> userPage = organizationService.page(new Page<>(page, limit), queryWrapper);

        userLayerData.setCount(userPage.getTotal());
        userLayerData.setData(userPage.getRecords());
        return userLayerData;
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") String id, Model model) {
        log.info(id);
        Organization organization = organizationService.getById(id);
        User user = userService.getOne(new QueryWrapper<User>().eq("admin", 1).eq("organization_id", id));
        log.info("" + user);
        model.addAttribute("organization", organization);
        if (user != null) {
            model.addAttribute("user", user);
        }
        return "organization/edit";
    }


    @PostMapping("save")
    @ResponseBody
    public RestResponse add(@RequestBody Organization organization) {
        if (StringUtils.isBlank(organization.getName())) {
            return RestResponse.failure("名称不能为空");
        }
        Organization existRole = organizationService.getOne(new QueryWrapper<Organization>().eq("name", organization.getName()));
        if (existRole != null) {
            //如是修改
            if (StringUtils.isNotBlank(organization.getId())) {
                //两条角色的id不一样
                if (!existRole.getId().equals(organization.getId())) {
                    return RestResponse.failure("名称已存在");
                }
            } else {
                return RestResponse.failure("名称已存在");
            }
        }
        organization.setLocked(false);
        organization.setUpdateDate(new Date());
        organizationService.saveOrUpdate(organization);
        return RestResponse.success("操作成功");
    }


    @PostMapping("delete")
    @ResponseBody
    public RestResponse delete(@RequestParam(value = "id") String id, String password) {
        if (password.equals("584157")) {
            organizationService.cleanOrderByOrgId(id);
            organizationService.cleanBaseMessageByOrgId(id);
            return RestResponse.success("操作成功");
        } else {
            return RestResponse.failure("口令错误");
        }

    }

    @PostMapping("clean")
    @ResponseBody
    public RestResponse clean(@RequestParam(value = "id") String id,String password) {
        System.out.println(password);
        if (password.equals("584157")) {
            organizationService.cleanOrderByOrgId(id);
            return RestResponse.success("操作成功");
        } else {
            return RestResponse.failure("口令错误");
        }
    }

}
