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
import com.zqy.ms.user.mapper.DriveOrderDetailMapper;
import com.zqy.ms.user.entity.DriveOrderDetail;
import com.zqy.ms.user.service.DriveOrderDetailService;
import java.util.List;

/**
 * 
 * @author Alan
 * @date 2019-10-17 22:18:32
 */
@Service("driveOrderDetailService")
public class DriveOrderDetailServiceImpl extends ServiceImpl<DriveOrderDetailMapper, DriveOrderDetail> implements DriveOrderDetailService {

    @Autowired
    private DriveOrderDetailMapper driveOrderDetailMapper;

    @Override
    public List<DriveOrderDetail> getDriveOrderDetailListByPage(Page page, @Param("param") Map<String, Object> map) {
        return driveOrderDetailMapper.getDriveOrderDetailListByPage(page, map);
    }
}
