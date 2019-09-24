package com.zqy.ms.user.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zqy.ms.user.entity.JpushLog;
import com.zqy.ms.user.entity.ao.JpushLogAO;
import com.zqy.ms.user.entity.ao.PushAO;
import com.zqy.ms.user.service.JpushLogService;
import com.zqy.ms.user.util.JpushClientUtil;
import com.zqy.ms.user.util.LayerData;
import com.zqy.ms.user.util.RestResponse;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;


/**
 * @author Alan
 * @date 2019-08-13 09:55:53
 */
@Controller
@RequestMapping("/jpush")
public class JpushLogController {
    @Autowired
    private JpushLogService jpushLogService;

    @Autowired
    private StringRedisTemplate redisTemplate;


    @Autowired
    private JpushClientUtil jpushUtils;

    @GetMapping("list")
    public String list() {
        return "jpush/list";
    }

    @ApiOperation(value = "分页查询")
    @PostMapping("/list")
    @ResponseBody
    public LayerData<JpushLog> sendInviteEmail(JpushLogAO jpushLogAo) {

        Page<JpushLog> page=new Page<>(jpushLogAo.getPage(),jpushLogAo.getLimit());
        QueryWrapper<JpushLog> entityWrapper = new QueryWrapper<>();
        if(StringUtils.isNotEmpty(jpushLogAo.getBeginTime())){
            entityWrapper.between("date_create", jpushLogAo.getBeginTime(), jpushLogAo.getEndTime());
        }
        IPage<JpushLog> pagedata = jpushLogService.page(page, entityWrapper);
        LayerData<JpushLog> layerData = new LayerData<>();
        layerData.setData(pagedata.getRecords());
        layerData.setCount(pagedata.getTotal());
        return layerData;
    }


    @GetMapping("add")
    public String add() {
        return "jpush/add";
    }

    @PostMapping("save")
    @ResponseBody
    public RestResponse save(@RequestBody JpushLog jpushLog, HttpServletRequest request) {
        String jsessionid = request.getSession().getId();
        System.out.println(jsessionid);
        String json = redisTemplate.opsForValue().get("user_session::" + jsessionid);
        System.out.println(json);
        JSONObject jsonObject=new JSONObject(json);
        jpushLog.setOperator(jsonObject.getString("nickName"));
        jpushLogService.save(jpushLog);

        HashMap<String, String> map = new HashMap<>(2);
        map.put("title", jpushLog.getTitle());
        map.put("msg", jpushLog.getMsg());
        PushAO pushAo = new PushAO();
        int num=jpushUtils.sendToRegistrationId(pushAo.getAlias(), pushAo.getTitle(), pushAo.getTitle(), pushAo.getMsg(), pushAo.getExtraParam());

        return num>0? RestResponse.success() : RestResponse.failure("操作失败!");
    }


}
