package com.zqy.ms.user.util;

import com.zqy.ms.user.entity.SysMenu;

public class Log {

    private static boolean print=true;
    public static void i(Object string){
        if(print){
            System.out.println(""+string);
        }

    }
}
