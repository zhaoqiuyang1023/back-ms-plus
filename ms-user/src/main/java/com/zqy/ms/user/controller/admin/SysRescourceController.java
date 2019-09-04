package com.zqy.ms.user.controller.admin;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zqy.ms.user.entity.SysRescource;
import com.zqy.ms.user.entity.ao.FilePageAO;
import com.zqy.ms.user.service.SysRescourceService;
import com.zqy.ms.user.util.LayerData;
import com.zqy.ms.user.util.RestResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.File;


/**
 * 系统资源
 *
 * @author Alan
 * @date 2019-08-01 10:54:19
 */
@Controller
@RequestMapping("/admin/file")
public class SysRescourceController {

    @Autowired
    private SysRescourceService sysRescourceService;

    @GetMapping("list")
    public String list() {
        return "admin/file/list";
    }

    @PostMapping("list")
    @ResponseBody
    public LayerData<SysRescource> list(FilePageAO filepageao) {
        LayerData<SysRescource> sysRescource = new LayerData<>();
        QueryWrapper<SysRescource> sysEntityWrapper = new QueryWrapper<>();
        sysEntityWrapper.orderByDesc("update_date");
        IPage<SysRescource> userPage = sysRescourceService.page(new Page<>(filepageao.getPage(), filepageao.getLimit()), sysEntityWrapper);
        sysRescource.setCount(userPage.getTotal());
        sysRescource.setData(userPage.getRecords());
        return sysRescource;
    }

    @PostMapping("delete")
    @ResponseBody
    public RestResponse delete(@RequestParam(value = "id", required = false) Long id) {
        SysRescource sysRescource = sysRescourceService.getById(id);
        String localUploadPath = System.getProperty("user.dir") + "/files/" + sysRescource.getFileName();
        File file=new File(localUploadPath);
        if (file.exists()){
            file.delete();
        }
        sysRescourceService.removeById(id);
        return RestResponse.success();
    }

}
