package com.zqy.ms.user;

import com.zqy.ms.user.entity.SysMenu;
import com.zqy.ms.user.entity.SysRole;
import com.zqy.ms.user.service.SysMenuService;
import com.zqy.ms.user.service.SysRoleService;
import com.zqy.ms.user.util.Log;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * @author : Alan
 * @date : 2019/8/1  15:26
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserApplicationTest {


    @Autowired
    private SysMenuService sysMenuService;

    @Autowired
    private SysRoleService sysRoleService;

    @Test
    public void ff (){


    }
}
