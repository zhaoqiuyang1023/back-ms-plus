package com.zqy.ms.user.config.shiro;
import com.zqy.ms.user.entity.SysMenu;
import com.zqy.ms.user.entity.SysUser;
import com.zqy.ms.user.service.SysMenuService;
import com.zqy.ms.user.util.Log;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.UnauthorizedException;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.PathMatchingFilter;
import org.apache.shiro.web.util.WebUtils;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

/**
 * @author : Alan
 * @date : 2019/8/30  17:23
 */


public class UrlPathMatchingFilter extends PathMatchingFilter {


    private SysMenuService sysMenuService;

    public UrlPathMatchingFilter(SysMenuService sysMenuService) {
        this.sysMenuService = sysMenuService;
    }


    @Override
    protected boolean onPreHandle(ServletRequest request, ServletResponse response, Object mappedValue)
            throws Exception {
        String requestUri = getPathWithinApplication(request);

        Log.i("requestURI:" + requestUri);
        Subject subject = SecurityUtils.getSubject();
        // 如果没有登录，就跳转到登录页面
        if (!subject.isAuthenticated()) {
            WebUtils.issueRedirect(request, response, "/login");
            return false;
        }
        // 看看这个路径权限里有没有维护，如果没有维护，一律放行
        boolean needInterceptor = sysMenuService.needInterceptor(requestUri);

        //数据库没有维护此链接方形
        if (!needInterceptor) {
            return true;
        }
        //如果有权限
        SysUser sysUser = (SysUser) subject.getPrincipal();
        for (SysMenu sysmenu : sysUser.getSysMenus()) {
            if(sysmenu.getHref().equals(requestUri)){
                Log.i("有此权限");
                return true;
            }
        }
        Log.i("没有权限");
        HttpServletRequest httpServlet=(HttpServletRequest)request;
        String requestAccept = httpServlet.getHeader("accept");

        String contentType = "text/html";


        //判断请求类型

        if (StringUtils.isNotEmpty(requestAccept)) {
            if (StringUtils.contains(requestAccept, "application/json") || StringUtils.contains(requestAccept, "text/javascript") || StringUtils.contains(requestAccept, "text/json")) {
                contentType = "application/json";
            }
        }
        if (contentType.equals("application/json")) {

            // 需要返回json
        }
        if (contentType.equals("text/html")) {
            WebUtils.issueRedirect(request, response, "/unauthorized");
        }

        return false;

    }
}
