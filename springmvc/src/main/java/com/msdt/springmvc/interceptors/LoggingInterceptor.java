package com.msdt.springmvc.interceptors;

import java.util.Date;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;

public class LoggingInterceptor implements HandlerInterceptor {

    private final static String SESSION_ID = "JSESSIONID";

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {

        // Get Cookies
        Cookie[] cookies = request.getCookies();
        // Log Session Id
        String sessionId = null;
        // Log request path

        if (null != cookies) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals(SESSION_ID)) {
                    sessionId = cookie.getValue();
                }
            }
        }

        System.out.println(
                "Session Id:: " + sessionId + ", comes at:: " + new Date() + " For:: " + request.getRequestURI());
        return true;
    }
}
