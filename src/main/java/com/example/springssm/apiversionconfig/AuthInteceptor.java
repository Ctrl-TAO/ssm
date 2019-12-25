package com.example.springssm.apiversionconfig;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author: taoshengjie
 * @Date: 2019/11/7 18:32
 * @Description:
 */
public class AuthInteceptor extends HandlerInterceptorAdapter
{

    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response, Object handler) throws Exception
    {
        System.out.println("URI: " + request.getRequestURI());
        return true;
    }


}