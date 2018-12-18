package com.zjmeow.bubble.config;

import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.web.filter.authc.BasicHttpAuthenticationFilter;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @description: 认证拦截器, 拦截登录请求, 自定义登录逻辑
 * @author: zjm
 **/


public class AuthFilter extends BasicHttpAuthenticationFilter {

    //检测请求是否需要鉴权(用户登录判断)
    @Override
    protected boolean isLoginAttempt(ServletRequest request, ServletResponse response) {
        HttpServletRequest req = (HttpServletRequest) request;
        String authorization = req.getHeader("S-TOKEN");
        return authorization != null;
    }

    //执行登录判断逻辑
    @Override
    protected boolean executeLogin(ServletRequest request, ServletResponse response) throws Exception {
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        // 获取session,且不自动创建
        HttpSession httpSession = httpServletRequest.getSession(false);
        // 无session代表请求头无session标志,或者该session标志无效(过期/错误)
        if (httpSession == null) {
            return false;
        }
        UsernamePasswordToken token = new UsernamePasswordToken(loginDTO.getPhone(), loginDTO.getPassword());
        UsernamePasswordToken authToken = new UsernamePasswordToken(httpSession);
        //登录判断,错误则抛出异常
        getSubject(request, response).login(authToken);
        return true;
    }

    //不阻挡所有请求，请求的最终合法性由接口上的注解判断
    @Override
    protected boolean isAccessAllowed(ServletRequest request, ServletResponse response, Object mappedValue) {
        if (isLoginAttempt(request, response)) {
            try {
                executeLogin(request, response);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return true;
    }

}