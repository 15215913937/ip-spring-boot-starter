package com.sqn.ipspringbootstarter.interceptor;

import com.sqn.ipspringbootstarter.service.IpCountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Author shenqn
 * @Date 2022/9/14  0:06
 */

public class IpCountInterceptor implements HandlerInterceptor {
    @Autowired
    IpCountService ipCountService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //        请求前执行ip访问监控
        ipCountService.ipCount();
        return true;
    }
}
