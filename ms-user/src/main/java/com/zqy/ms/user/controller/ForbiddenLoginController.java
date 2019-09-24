package com.zqy.ms.user.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zqy.ms.user.entity.ForbiddenLogin;
import com.zqy.ms.user.entity.Organization;
import com.zqy.ms.user.entity.User;
import com.zqy.ms.user.entity.ao.ForbiddenAO;
import com.zqy.ms.user.service.ForbiddenLoginService;
import com.zqy.ms.user.service.OrganizationService;
import com.zqy.ms.user.service.UserService;
import com.zqy.ms.user.util.LayerData;
import com.zqy.ms.user.util.RestResponse;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;


/**
 * @author Alan
 * @date 2019-07-17 10:53:52
 */
@Controller
@RequestMapping("/forbiddenlogin")
public class ForbiddenLoginController {

    @Autowired
    private ForbiddenLoginService forbiddenLoginService;


    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Autowired
    private UserService userService;

    @Autowired
    private OrganizationService organizationService;

    @GetMapping("/list")
    public String list(Model model) {

        model.addAttribute("accounts", organizationService.list(new QueryWrapper<>()));
        return "forbidden/user/list" ;
    }

    @PostMapping("/list")
    @ResponseBody
    public LayerData<ForbiddenLogin> list(ForbiddenAO announcementAo) {
        Page<ForbiddenLogin> paged = new Page<>(announcementAo.getPage(), announcementAo.getLimit());
        QueryWrapper<ForbiddenLogin> entityWrapper = new QueryWrapper<>();
        if (StringUtils.isNotEmpty(announcementAo.getUserName())) {
            entityWrapper.like("user_name", announcementAo.getUserName());
        }
        if (StringUtils.isNotEmpty(announcementAo.getAccountName())) {
            entityWrapper.like("account_name", announcementAo.getAccountName());
        }
        if (StringUtils.isNotEmpty(announcementAo.getStartTime())) {
            entityWrapper.between("date_create", announcementAo.getStartTime(), announcementAo.getEndTime());
        }

        IPage<ForbiddenLogin> page = forbiddenLoginService.page(paged, entityWrapper);
        LayerData<ForbiddenLogin> layerData = new LayerData<>();
        List<ForbiddenLogin> newsSettings = page.getRecords();
        layerData.setData(newsSettings);
        layerData.setCount(page.getTotal());
        return layerData;
    }

    @PostMapping("/del/{id}")
    @ResponseBody
    public RestResponse del(@PathVariable String id) {
        ForbiddenLogin forbiddenLogin = forbiddenLoginService.getById(id);
        String key = BLACKLIST_USER_KEY + COLON + forbiddenLogin.getUserName();
        //  stringRedisTemplate.delete(key);
        return forbiddenLoginService.removeById(id) ? RestResponse.success() : RestResponse.failure("操作失败!");

    }


    @GetMapping("/add")
    public String add() {

        return "forbidden/user/add" ;
    }

    @GetMapping("/adddomain")
    public String adddomain() {

        return "forbidden/user/adddomain" ;
    }


    private static final String BLACKLIST_USER_KEY = "blacklist_user" ;
    private static final String COLON = ":" ;

    @PostMapping("/save")
    @ResponseBody
    public RestResponse add(@RequestBody ForbiddenLogin forbiddenLogin) {
        List<ForbiddenLogin> forbiddenLoins = forbiddenLoginService.list(new QueryWrapper<ForbiddenLogin>().eq("user_name", forbiddenLogin.getUserName()));
        if (forbiddenLoins.size() > 0) {
            return RestResponse.failure("操作失败!账号存在，请勿重复添加");
        }
        User user = userService.getOne(new QueryWrapper<User>().eq("tel", forbiddenLogin.getUserName()));
        if (user != null) {
            Organization account = organizationService.getById(user.getOrganizationId());
            forbiddenLogin.setAccountName(account.getName());
        }
        //  stringRedisTemplate.opsForValue().set(BLACKLIST_USER_KEY + COLON + forbiddenLogin.getUserName(), forbiddenLogin.getUserName());
        forbiddenLogin.setDateCreate(new Date());
        forbiddenLogin.setUserName(forbiddenLogin.getUserName());
        forbiddenLogin.setLoginStatus("0");
        return forbiddenLoginService.saveOrUpdate(forbiddenLogin) ? RestResponse.success() : RestResponse.failure("操作失败!");
    }
}
