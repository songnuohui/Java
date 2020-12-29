package com.song.trip.web.interceptor;

import com.song.trip.web.domain.Admin;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        Admin admin = (Admin) httpServletRequest.getSession().getAttribute("admin");
/*
        System.out.println("是否获取到admin"+admin);
*/
        //未登录
        if(admin==null) {
            httpServletResponse.sendRedirect(httpServletRequest.getContextPath()+"/admin/login");
        }
        //登录后放行
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
