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
import com.zqy.ms.user.mapper.DriveBackOrderMapper;
import com.zqy.ms.user.entity.DriveBackOrder;
import com.zqy.ms.user.service.DriveBackOrderService;
import java.util.List;

/**
 * 
 * @author Alan
 * @date 2019-10-17 22:18:32
 */
@Service("driveBackOrderService")
public class DriveBackOrderServiceImpl extends ServiceImpl<DriveBackOrderMapper, DriveBackOrder> implements DriveBackOrderService {

    @Autowired
    private DriveBackOrderMapper driveBackOrderMapper;

    @Override
    public List<DriveBackOrder> getDriveBackOrderListByPage(Page page, @Param("param") Map<String, Object> map) {
        return driveBackOrderMapper.getDriveBackOrderListByPage(page, map);
    }
}
