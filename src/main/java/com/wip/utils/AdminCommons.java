/**
 * Created by IntelliJ IDEA.
 * User: Administrator
 * DateTime: 2018/7/24 23:26
 **/
package com.wip.utils;

import org.springframework.stereotype.Component;

/**
 * 后台公共函数
 */
@Component
public final class AdminCommons {

    /**
     * 定义颜色样式数组
     */
    private static final String[] COLORS = {"default", "primary", "success", "info", "warning", "danger", "inverse", "purple", "pink"};


    public static String rand_color() {
        int r = Tools.rand(0, COLORS.length - 1);
        return COLORS[r];
    }

}
