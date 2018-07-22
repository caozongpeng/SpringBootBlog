package com.wip.constant;

import org.springframework.stereotype.Component;

@Component
public class WebConst {

    /**
     * 用户登录session的key
     */
    public static String LOGIN_SESSION_KEY = "login_user";

    public static final String USER_IN_COOKIE = "S_L_ID";


    public static String AES_SALT = "0123456789abcdef";


}
