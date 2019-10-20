package com.zqy.ms.user.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.additional.query.impl.QueryChainWrapper;
import com.zqy.ms.user.entity.*;
import com.zqy.ms.user.mapper.*;
import com.zqy.ms.user.service.RolePermissionPkService;
import net.bytebuddy.asm.Advice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.ibatis.annotations.Param;

import java.util.Map;

import javafx.scene.control.Pagination;
import com.zqy.ms.user.service.OrganizationService;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author @Alan
 * @date 2019-09-20 21:56:51
 */
@Service("organizationService")
public class OrganizationServiceImpl extends ServiceImpl<OrganizationMapper, Organization> implements OrganizationService {

    @Autowired
    private OrganizationMapper organizationMapper;


    @Autowired
    private DriveOrderMapper driveOrderMapper;

    @Autowired
    private DriveOrderDetailMapper driveOrderDetailMapper;

    @Autowired
    private DeliveryOrderMapper deliveryOrderMapper;

    @Autowired
    private DeliveryOrderDetailMapper deliveryOrderDetailMapper;

    @Autowired
    private DriveBackOrderMapper driveBackOrderMapper;

    @Autowired
    private DriveBackOrderDetailMapper driveBackOrderDetailMapper;


    @Autowired
    private ReceiptOrderMapper receiptOrderMapper;

    @Autowired
    private ReceiptOrderDetailMapper receiptOrderDetailMapper;

    @Autowired
    private CarMapper carMapper;

    @Autowired
    private GoodsMapper goodsMapper;
    @Autowired
    private RoleMapper roleMapper;
    @Autowired
    private RolePermissionPkMapper rolePermissionPkMapper;

    @Autowired
    private RouteMapper routeMapper;

    @Autowired
    private RouteShopPkMapper routeShopPkMapper;

    @Autowired
    private ShopMapper shopMapper;

    @Autowired
    private UserRolePkMapper userRolePkMapper;



    @Transactional(rollbackFor = Exception.class)
    @Override
    public void cleanOrderByOrgId(String id) {
        List<DriveOrder> driveOrders = driveOrderMapper.selectList(new QueryWrapper<DriveOrder>().eq("organization_id", id));
        for (DriveOrder driveOrder : driveOrders) {
            driveOrderDetailMapper.delete(new QueryWrapper<DriveOrderDetail>().eq("drive_order_id", driveOrder.getId()));
            driveOrderMapper.deleteById(driveOrder.getId());
        }
        List<DeliveryOrder> deliveryOrders = deliveryOrderMapper.selectList(new QueryWrapper<DeliveryOrder>().eq("organization_id", id));
        for (DeliveryOrder driveOrder : deliveryOrders) {
            deliveryOrderDetailMapper.delete(new QueryWrapper<DeliveryOrderDetail>().eq("delivery_order_id", driveOrder.getId()));
            deliveryOrderMapper.deleteById(driveOrder.getId());
        }

        List<DriveBackOrder> driveBackOrders = driveBackOrderMapper.selectList(new QueryWrapper<DriveBackOrder>().eq("organization_id", id));
        for (DriveBackOrder driveBackOrder : driveBackOrders) {
            driveBackOrderDetailMapper.delete(new QueryWrapper<DriveBackOrderDetail>().eq("drive_back_order_id", driveBackOrder.getId()));
            driveBackOrderMapper.deleteById(driveBackOrder.getId());
        }

        List<ReceiptOrder> receiptOrders = receiptOrderMapper.selectList(new QueryWrapper<ReceiptOrder>().eq("organization_id", id));
        for (ReceiptOrder receiptOrder : receiptOrders) {
            receiptOrderDetailMapper.delete(new QueryWrapper<ReceiptOrderDetail>().eq("receipt_order_id", receiptOrder.getId()));
            receiptOrderMapper.deleteById(receiptOrder.getId());
        }
    }

    @Override
    public void cleanBaseMessageByOrgId(String id) {
        organizationMapper.deleteById(id);
        goodsMapper.delete(new QueryWrapper<Goods>().eq("organization_id", id));
        carMapper.delete(new QueryWrapper<Car>().eq("organization_id", id));
        List<Route> routeList = routeMapper.selectList(new QueryWrapper<Route>().eq("organization_id", id));
        for (Route route : routeList) {
            routeShopPkMapper.delete(new QueryWrapper<RouteShopPk>().eq("route_id", route.getId()));
            routeMapper.deleteById(route.getId());
        }
        List<Role> roleList = roleMapper.selectList(new QueryWrapper<Role>().eq("organization_id", id));
        for (Role role : roleList) {
            rolePermissionPkMapper.delete(new QueryWrapper<RolePermissionPk>().eq("role_id", role.getId()));
            userRolePkMapper.delete(new QueryWrapper<UserRolePk>().eq("role_id", role.getId()));
            roleMapper.deleteById(role.getId());
        }
       //  shopMapper.delete(new QueryWrapper<Shop>().eq("organization_id", id));

    }
}
