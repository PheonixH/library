package com.example.demo.interceptor;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @program: demo
 * @className: LoginInterceptor
 * @description: login interceptor
 * @author: lov.moran
 * @date 2020/5/30 下午3:03
 */
public class LoginInterceptor extends HandlerInterceptorAdapter {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Cookie[] cookies = request.getCookies();
        if (null == cookies) {
            System.out.println("============缺少cookie==========");
        } else {
            for (Cookie cookie : cookies) {
                if ("isLogin".equals(cookie.getName())) {
                    return true;
                }
            }
        }
        response.sendRedirect("/login/index");
        return false;
    }
}
