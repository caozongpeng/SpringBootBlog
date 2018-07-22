package com.wip.utils;

import org.springframework.stereotype.Component;

import java.util.Random;


/**
 * 公共函数
 */
@Component
public class Commons {


    /**
     * 获取随机数数
     * @param max
     * @param str
     * @return
     */
    public static String random(int max, String str) {
        return UUID.random(1,max) + str;
    }

    public static String random(Long seed, int max, String str) {
        if (seed == null) {
            return random(max, str);
        }
        Random random = new Random(seed);
        return random.nextInt(max) +str;
    }




}
