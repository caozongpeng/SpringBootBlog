package com.wip.controller;

import com.wip.utils.MapCache;

import javax.servlet.http.HttpServletRequest;

public abstract class BaseController {


    protected MapCache cache = MapCache.single();


    public BaseController title(HttpServletRequest request, String title) {
        request.setAttribute("title", title);
        return this;
    }


    /**
     * 数组转字符串
     * @param arr 数组
     * @return String
     */
    public String join(String[] arr) {
        StringBuffer buffer = new StringBuffer();
        String[] temp = arr;
        int length = arr.length;

        for (int i = 0; i < length; i++) {
            String item = temp[i];
            buffer.append(",").append(item);
        }

        return buffer.length() > 0 ? buffer.substring(1) : buffer.toString();
    }


}
