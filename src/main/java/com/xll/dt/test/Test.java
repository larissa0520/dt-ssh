package com.xll.dt.test;

import com.xll.dt.util.PasswordUtil;

/**
 * 描述:
 *   测试
 * @aouthor larissa
 * @create 2018-02-23 10:02
 */
public class Test {
    public static void main(String arg[]){
        String password = PasswordUtil.md5("111", "admin");
        System.out.println(password);
    }

}
