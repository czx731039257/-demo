package com.csx.demo2.filter;

import org.apache.tomcat.jni.File;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


@WebFilter(urlPatterns = {"/message","/create","/edit","/editperson","/person","/users"}, filterName = "authFilter")
public class MyFilter implements javax.servlet.Filter {
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("过滤器初始化！");
    }

    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("拦截请求。。。。。。。。。");
        HttpServletRequest request=(HttpServletRequest)servletRequest;
        HttpSession session = request.getSession();//获取session域

        String requestURI = request.getRequestURI();
        System.out.println(requestURI);
        int i = requestURI.indexOf("/", 1);
        String substring = requestURI.substring(i+1);
        System.out.println(substring);
        if(session.getAttribute("user")==null){//还未登入
            ((HttpServletResponse)servletResponse).sendRedirect("login");//跳转回登入页
        }else {//已经登入过了
            filterChain.doFilter(servletRequest,servletResponse);
        }
    }

    public void destroy() {
        System.out.println("过滤器销毁！");
    }
}
