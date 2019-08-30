package com.zqy.ms.user.config.shiro;

import com.zqy.ms.user.service.SysMenuService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.authz.UnauthorizedException;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.PathMatchingFilter;
import org.apache.shiro.web.util.WebUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.util.Set;

/**
 * @author : Alan
 * @date : 2019/8/30  17:23
 */
@Component
public class UrlPathMatchingFilter extends PathMatchingFilter {


    @Autowired
    SysMenuService sysMenuService;

    @Override
    protected boolean onPreHandle(ServletRequest request, ServletResponse response, Object mappedValue)
            throws Exception {
        String requestUri = getPathWithinApplication(request);

        System.out.println("requestURI:" + requestUri);

        Subject subject = SecurityUtils.getSubject();
        // 如果没有登录，就跳转到登录页面
        if (!subject.isAuthenticated()) {
            WebUtils.issueRedirect(request, response, "/login");
            return false;
        }

        // 看看这个路径权限里有没有维护，如果没有维护，一律放行
        boolean needInterceptor = sysMenuService.needInterceptor(requestUri);
        //如果需要拦截
        if (needInterceptor) {
            Set<String> permissionUrls =((SimpleAuthorizationInfo)SecurityUtils.getSubject().getPrincipal()).getStringPermissions();
            //如果有权限
            if (permissionUrls.contains(requestUri)) {
                return true;
            } else {
                UnauthorizedException ex = new UnauthorizedException("当前用户没有访问路径 " + requestUri + " 的权限");
                subject.getSession().setAttribute("ex", ex);
                WebUtils.issueRedirect(request, response, "/unauthorized");
                return false;
            }
        } else {
            return true;
        }
    }

}
