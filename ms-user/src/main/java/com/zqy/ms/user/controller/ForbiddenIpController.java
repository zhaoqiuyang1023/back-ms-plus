package com.zqy.ms.user.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zqy.ms.user.entity.ForbiddenIp;
import com.zqy.ms.user.entity.IpMessage;
import com.zqy.ms.user.entity.ao.ForbiddenAO;
import com.zqy.ms.user.service.ForbiddenIpService;
import com.zqy.ms.user.service.ThirdApiService;
import com.zqy.ms.user.util.LayerData;
import com.zqy.ms.user.util.RestResponse;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
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
@RequestMapping("/forbiddenip")
public class ForbiddenIpController {
    @Autowired
    private ForbiddenIpService forbiddenIpService;

    @Autowired
    private ThirdApiService thirdApiService;



    @GetMapping("/list")
    public String list(Model model) {

        return "forbidden/ip/list";
    }

    @PostMapping("/list")
    @ResponseBody
    public LayerData<ForbiddenIp> list(ForbiddenAO announcementAo) {
        Page<ForbiddenIp> paged = new Page<>(announcementAo.getPage(), announcementAo.getLimit());
        QueryWrapper<ForbiddenIp> queryWrapper = new QueryWrapper<>();

        if (StringUtils.isNotEmpty(announcementAo.getUserName())) {
            queryWrapper.eq("ip", announcementAo.getUserName());
        }
        if (StringUtils.isNotEmpty(announcementAo.getStartTime())) {
            queryWrapper.between("date_create", announcementAo.getStartTime(), announcementAo.getEndTime());
        }

        IPage<ForbiddenIp> page = forbiddenIpService.page(paged, queryWrapper);
        LayerData<ForbiddenIp> layerData = new LayerData<>();
        List<ForbiddenIp> newsSettings = page.getRecords();
        layerData.setData(newsSettings);
        layerData.setCount(page.getTotal());
        return layerData;
    }

    @PostMapping("/del/{id}")
    @ResponseBody
    public RestResponse del(@PathVariable String id) {
        ForbiddenIp forbiddenIp = forbiddenIpService.getById(id);
        String key = BLACKLIST_IP_KEY + COLON + forbiddenIp.getIp();
     //   stringRedisTemplate.delete(key);
        return forbiddenIpService.removeById(id) ? RestResponse.success() : RestResponse.failure("操作失败!");

    }


    @GetMapping("/add")
    public String add() {

        return "forbidden/ip/add";
    }

    private static final String BLACKLIST_IP_KEY = "blacklist_ip";
    private static final String COLON = ":";

    @PostMapping("/save")
    @ResponseBody
    public RestResponse add(@RequestBody ForbiddenIp forbiddenIp) {
        List<ForbiddenIp> forbiddenIps = forbiddenIpService.list(new QueryWrapper<ForbiddenIp>().eq("ip", forbiddenIp.getIp()));
        if(forbiddenIps.size()>0){
          return   RestResponse.failure("操作失败!账号存在，请勿重复添加");
        }
      //  stringRedisTemplate.opsForValue().set(BLACKLIST_IP_KEY + COLON + forbiddenIp.getIp(), forbiddenIp.getIp());
        IpMessage ipMessage = thirdApiService.ipMessage(forbiddenIp.getIp());
        forbiddenIp.setDateCreate(new Date());
        forbiddenIp.setDateUpdate(new Date());
        forbiddenIp.setCountry(ipMessage.getCountry());
        forbiddenIp.setIpStatus("0");
        return forbiddenIpService.saveOrUpdate(forbiddenIp) ? RestResponse.success() : RestResponse.failure("操作失败!");
    }

}
