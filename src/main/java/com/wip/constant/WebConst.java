package com.wip.constant;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * 系统常量
 */
@Component
public class WebConst {


    /**
     * 一些网站配置
     */
    public static Map<String, String> initConfig = new HashMap<>();


    /**
     * 用户登录session的key
     */
    public static String LOGIN_SESSION_KEY = "login_user";

    public static final String USER_IN_COOKIE = "S_L_ID";


    /**
     * aes加密加盐
     */
    public static String AES_SALT = "0123456789abcdef";
    /**
     * 最大获取文章条数
     */
    public static final int MAX_POSTS = 9999;

    /**
     * 文章标题最多可以输入的文字个数
     */
    public static final int MAX_TITLE_COUNT = 200;

    /**
     * 文章内容最多可以输入的文字个数
     */
    public static final int MAX_CONTENT_COUNT = 200000;

    /**
     * 点击次数超过铄和更新到数据库
     */
    public static final int HIT_EXEED = 10;

    /**
     * 上传文件最大1M
     */
    public static Integer MAX_FILE_SIZE = 1048576;


}
