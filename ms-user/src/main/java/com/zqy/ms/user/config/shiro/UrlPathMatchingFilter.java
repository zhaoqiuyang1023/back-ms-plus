package com.zqy.ms.user.config.shiro;

import com.alibaba.fastjson.JSON;
import com.zqy.ms.user.entity.SysMenu;
import com.zqy.ms.user.entity.SysUser;
import com.zqy.ms.user.service.SysMenuService;
import com.zqy.ms.user.util.Log;
import com.zqy.ms.user.util.RestResponse;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.UnauthorizedException;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.PathMatchingFilter;
import org.apache.shiro.web.util.WebUtils;
import org.json.JSONTokener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * @author : Alan
 * @date : 2019/8/30  17:23
 */

@Slf4j
public class UrlPathMatchingFilter extends PathMatchingFilter {


    private SysMenuService sysMenuService;


    private StringRedisTemplate redisTemplate;


    public UrlPathMatchingFilter(SysMenuService sysMenuService, StringRedisTemplate redisTemplate) {
        this.sysMenuService = sysMenuService;
        this.redisTemplate = redisTemplate;
    }


    @Override
    protected boolean onPreHandle(ServletRequest request, ServletResponse response, Object mappedValue)
            throws Exception {
        String requestUri = getPathWithinApplication(request);

        Log.i("requestURI:" + requestUri);
        Subject subject = SecurityUtils.getSubject();
        List<String> res = new ArrayList<>();
        res.add("/index");
        res.add("/");
        res.add("/login");
        res.add("/unLogin");
        res.add("/static");
        res.add("/js");
        // 如果没有登录，就跳转到登录页面
        if (res.indexOf(requestUri) > 0) {
            return Boolean.TRUE;
        }
        if (!subject.isAuthenticated()) {
            WebUtils.issueRedirect(request, response, "/unLogin");
            return false;
        }
        SysUser sysUser = (SysUser) subject.getPrincipal();
        if (sysUser.getLocked()) {
            subject.logout();
            WebUtils.issueRedirect(request, response, "/locked");
        }
        // 看看这个路径权限里有没有维护，如果没有维护，一律放行
        boolean needInterceptor = sysMenuService.needInterceptor(requestUri);

        //数据库没有维护话就放行
        if (!needInterceptor) {
            return true;
        }
        if (redisTemplate.opsForValue().get("permission:" + sysUser.getId()) == null) {
            List<SysMenu> latestPermissions = sysMenuService.findPermissionUrlsByUserId(sysUser.getId());
            redisTemplate.opsForValue().set("permission:" + sysUser.getId(), JSON.toJSONString(latestPermissions));
        }
        String str = redisTemplate.opsForValue().get("permission:" + sysUser.getId());
        List<SysMenu> latestPermissions = JSON.parseArray(str, SysMenu.class);
        //如果有权限


        for (SysMenu sysmenu : latestPermissions) {
            if (sysmenu.getHref().equals(requestUri)) {
                Log.i("有此权限");
                return true;
            }
        }
        Log.i("没有权限");
        HttpServletRequest httpServlet = (HttpServletRequest) request;
        String requestAccept = httpServlet.getHeader("Content-Type");
        String contentType = "text/html";
        log.info(requestAccept);

        //判断请求类型

        if (StringUtils.isNotEmpty(requestAccept)) {
            if (StringUtils.contains(requestAccept, "application/x-www-form-urlencoded") || StringUtils.contains(requestAccept, "application/json") || StringUtils.contains(requestAccept, "text/javascript") || StringUtils.contains(requestAccept, "text/json")) {
                contentType = "application/json";
            }
        }
        if (contentType.equals("application/json")) {
            String message = JSON.toJSONString(RestResponse.failure("没有权限"));
            response.setCharacterEncoding("UTF-8");
            response.setContentType("application/json; charset=UTF-8");
            OutputStream outputStream = response.getOutputStream();
            outputStream.write(message.getBytes("UTF-8"));
            outputStream.flush();
            outputStream.close();

            log.info("需要返回json");
        }
        if (contentType.equals("text/html")) {
            WebUtils.issueRedirect(request, response, "/unauthorized");
        }

        return false;

    }
}
