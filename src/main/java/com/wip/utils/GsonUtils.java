/**
 * Created by IntelliJ IDEA.
 * User: Kyrie
 * DateTime: 2018/7/24 11:46
 **/
package com.wip.utils;

import com.google.gson.Gson;

/**
 * json转换工具
 */
public class GsonUtils {
    private static final Gson gson = new Gson();

    public static String toJsonString(Object object) {
        return object == null ? null : gson.toJson(object);
    }
}
