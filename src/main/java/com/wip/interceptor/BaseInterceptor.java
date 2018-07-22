package com.wip.interceptor;

import com.wip.model.UserDomain;
import com.wip.utils.Commons;
import com.wip.utils.IPKit;
import com.wip.utils.TaleUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 自定义拦截器
 */
@Component
public class BaseInterceptor implements HandlerInterceptor {

    private static final Logger LOGGER = LoggerFactory.getLogger(BaseInterceptor.class);
    private static final String USER_AGENT = "user-agent";

    @Autowired
    private Commons commons;



    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object o) throws Exception {

        // 请求URL不包含域名
        String uri = request.getRequestURI();
//        System.out.println(uri);

        LOGGER.info("UserAgent：{}", request.getHeader(USER_AGENT));
        LOGGER.info("用户访问地址：{}，来路地址：{}",uri, IPKit.getIpAddressByRequest1(request));

        // 请求拦截处理
        UserDomain user = TaleUtils.getLoginUser(request);
        if (null == user) {
            Integer uid = TaleUtils.getCookieUid(request);
        }


        return true;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

        httpServletRequest.setAttribute("commons",commons);

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
