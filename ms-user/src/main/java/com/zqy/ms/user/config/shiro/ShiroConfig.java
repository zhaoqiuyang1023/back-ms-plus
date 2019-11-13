package com.zqy.ms.user.config.shiro;

import com.zqy.ms.user.service.SysMenuService;
import com.zqy.ms.user.util.Log;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.spring.LifecycleBeanPostProcessor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.core.annotation.Order;
import org.springframework.data.redis.core.StringRedisTemplate;

import javax.servlet.Filter;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;


/**
 * @author : Alan
 * @date : 2019/7/31  17:46
 */
@Configuration
@Lazy
public class ShiroConfig {


    @Autowired
    private SysMenuService sysMenuService;

    @Autowired
    private StringRedisTemplate redisTemplate;

    @Bean
    public static LifecycleBeanPostProcessor getLifecycleBeanPostProcessor() {
        return new LifecycleBeanPostProcessor();
    }



    @Bean
    public ShiroFilterFactoryBean shirFilter(SecurityManager securityManager) {
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        shiroFilterFactoryBean.setSecurityManager(securityManager);
        // setLoginUrl 如果不设置值，默认会自动寻找Web工程根目录下的"/login.jsp"页面 或 "/login" 映射
        shiroFilterFactoryBean.setLoginUrl("/login");
        // 设置无权限时跳转的 url;
        shiroFilterFactoryBean.setUnauthorizedUrl("/notRole");

        /* 设置拦截器*/
        Map<String, String> filterChainDefinitionMap = new LinkedHashMap<>();
        /* 自定义过滤器*/
        filterChainDefinitionMap.put("/login/**", "anon");
        filterChainDefinitionMap.put("/index/**", "anon");
        filterChainDefinitionMap.put("/file/download/**", "anon");
        filterChainDefinitionMap.put("/unLogin/**", "anon");
        filterChainDefinitionMap.put("/static/**", "anon");
        filterChainDefinitionMap.put("/genCaptcha/**", "anon");
        filterChainDefinitionMap.put("/unauthorized/**", "anon");
        filterChainDefinitionMap.put("/locked/**", "anon");


        UrlPathMatchingFilter urlPathMatchingFilter = new UrlPathMatchingFilter(sysMenuService,redisTemplate);

        HashMap<String, Filter> map = new HashMap<>(2);
        System.out.println(urlPathMatchingFilter);
        Log.i(sysMenuService);
        map.put("requestURL", urlPathMatchingFilter);
        shiroFilterFactoryBean.setFilters(map);


        //其余接口一律拦截

        //加入自定义过滤器
        filterChainDefinitionMap.put("/**", "requestURL");

        //主要这行代码必须放在所有权限设置的最后，不然会导致所有 url 都被拦截
        //  filterChainDefinitionMap.put("/**", "authc");


        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterChainDefinitionMap);

        System.out.println("Shiro拦截器工厂类注入成功");
        return shiroFilterFactoryBean;
    }

    /**
     * 注入 securityManager
     *
     * @return
     */
    @Bean
    public DefaultWebSecurityManager securityManager() {
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        // 设置realm.
        securityManager.setRealm(customRealm());
        return securityManager;
    }

    /**
     * 自定义身份认证 realm;
     * <p>
     * 必须写这个类，并加上 @Bean 注解，目的是注入 CustomRealm，
     * 否则会影响 CustomRealm类 中其他类的依赖注入
     */
    @Bean
    public CustomRealm customRealm() {
        return new CustomRealm();
    }

}
