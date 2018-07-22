package com.wip.utils;

import com.wip.constant.WebConst;
import com.wip.model.UserDomain;
import org.apache.commons.lang3.StringUtils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class TaleUtils {

    /**
     * 获取session中的用户
     * @param request
     * @return
     */
    public static UserDomain getLoginUser(HttpServletRequest request) {
        HttpSession session = request.getSession();
        if (null == session) {
            return null;
        }
        return (UserDomain) session.getAttribute(WebConst.LOGIN_SESSION_KEY);
    }

    public static Integer getCookieUid(HttpServletRequest request){
        if (null != request) {
            Cookie cookie = cookieRaw(WebConst.USER_IN_COOKIE,request);
            if (cookie != null && cookie.getValue() != null) {
                try {
                    String uid = Tools.deAes(cookie.getValue(), WebConst.AES_SALT);
                    return StringUtils.isNotBlank(uid) && Tools.isNumber(uid) ? Integer.valueOf(uid) : null;
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }

    private static Cookie cookieRaw(String name, HttpServletRequest request) {
        Cookie[] servletCookies = request.getCookies();
        if (servletCookies == null) {
            return null;
        }
        for (Cookie c: servletCookies) {
            if (c.getName().equals(name)) {
                return c;
            }
        }
        return null;
    }



}
