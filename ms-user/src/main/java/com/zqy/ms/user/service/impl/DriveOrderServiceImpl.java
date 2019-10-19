package com.zqy.ms.user.service.impl;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Map;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.ibatis.annotations.Param;
import java.util.Map;
import javafx.scene.control.Pagination;
import com.zqy.ms.user.mapper.DriveOrderMapper;
import com.zqy.ms.user.entity.DriveOrder;
import com.zqy.ms.user.service.DriveOrderService;
import java.util.List;

/**
 * 
 * @author Alan
 * @date 2019-10-17 22:18:31
 */
@Service("driveOrderService")
public class DriveOrderServiceImpl extends ServiceImpl<DriveOrderMapper, DriveOrder> implements DriveOrderService {

    @Autowired
    private DriveOrderMapper driveOrderMapper;

    @Override
    public List<DriveOrder> getDriveOrderListByPage(Page page, @Param("param") Map<String, Object> map) {
        return driveOrderMapper.getDriveOrderListByPage(page, map);
    }
}
