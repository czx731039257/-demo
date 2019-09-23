package com.demo.sis.handler;


import org.apache.shiro.authz.AuthorizationException;
import org.springframework.web.bind.annotation.ControllerAdvice;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ExceptionHandler {

    @org.springframework.web.bind.annotation.ExceptionHandler({AuthorizationException.class})
    public String exce(HttpServletRequest req){
        System.out.println("你没有这个角色或权限");
        return "redirect:"+"message";
    }
}
