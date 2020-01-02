package com.accp.intercetor;

import com.accp.controller.LoginRestController;
import com.accp.domain.User;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class Intercetor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        if (handler instanceof HandlerMethod){
            HandlerMethod method = (HandlerMethod) handler;
            if (method.getBean() instanceof LoginRestController){
                return true;
            }
        }

        User user = (User) request.getSession().getAttribute("user");
        if (user !=null){
            return true;
        }
        return false;
    }
}
