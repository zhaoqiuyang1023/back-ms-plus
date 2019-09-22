package com.zqy.ms.user.util;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.util.DigestUtils;
import org.springframework.util.StringUtils;

/**
 * 自定义密码认证器
 */

@Slf4j
public class PasswordEncoderUtils {



    private static BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();



    /**
     * 密码加密
     *
     * @param raw String 原始密码
     * @return String 加密后的密码
     */
    public static  String encode(CharSequence raw) {
        return bCryptPasswordEncoder.encode(raw);
    }

    /**
     * 密码校验
     *
     * @param raw            String 原始密码
     * @param encodePassword String 加密后的密码
     * @return true | false
     */
    public boolean matches(CharSequence raw, String encodePassword) {
        log.info("原始密码" + raw);
        log.info("数据库存入的密码" + encodePassword);

        return bCryptPasswordEncoder.matches(raw, encodePassword);
    }
}
