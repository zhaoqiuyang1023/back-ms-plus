package com.zqy.ms.user.config;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.zqy.ms.user.entity.SysUser;
import com.zqy.ms.user.service.SysMenuService;
import com.zqy.ms.user.service.SysUserService;
import com.zqy.ms.user.util.Log;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Set;

/**
 * @author : Alan
 * @date : 2019/7/31  17:48
 */
@Component
public class CustomRealm extends AuthorizingRealm {

    @Autowired
    private SysUserService sysUserService;

    @Autowired
    private SysMenuService sysMenuService;


    /**
     * 获取身份验证信息
     * Shiro中，最终是通过 Realm 来获取应用程序中的用户、角色及权限信息的。
     *
     * @param authenticationToken 用户身份信息 token
     * @return 返回封装了用户信息的 AuthenticationInfo 实例
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        System.out.println("————身份认证方法————,UsernamePasswordToken是前端传过来的明文对象");
        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
        SysUser user = sysUserService.getOne(new QueryWrapper<SysUser>().eq("login_name", token.getUsername()));
        if (null == user) {
            throw new UnknownAccountException("用户名不正确");
            //这里用明文
        } else if (!user.getPassword().equals(new String(token.getPassword()))) {
            throw new IncorrectCredentialsException("密码不正确");
        }
        //这里把SysUser对象封装以便使用
        user.setSysRoles(sysUserService.findSysRolesByUserId(user.getId()));
        user.setSysMenus(sysUserService.findSysMenusByUserId(user.getId()));
        return new SimpleAuthenticationInfo(user, user.getPassword(), getName());
    }

    /**
     * 获取授权信息
     *
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        System.out.println("————权限认证————");
        SysUser sysUser =  (SysUser) SecurityUtils.getSubject().getPrincipal();
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        //获得该用户角色
        Set<String> roles = sysUserService.selectRolesByUserName(sysUser.getLoginName());
        Set<String> permissionSet = sysMenuService.selectPermissionByUserName(sysUser.getLoginName());
        Log.i(roles);
        //设置该用户拥有的角色和权限
        info.setRoles(roles);
     //   info.setStringPermissions(permissionSet);
        return info;
    }
}
