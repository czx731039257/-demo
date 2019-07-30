package com.demo.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class Filter implements javax.servlet.Filter {
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("过滤器初始化！");
    }

    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("拦截请求。。。。。。。。。");
        HttpServletRequest request=(HttpServletRequest)servletRequest;
        HttpSession session = request.getSession();//获取session域
        if(session.getAttribute("user")==null){//还未登入
            request.getRequestDispatcher("login.jsp").forward(servletRequest,servletResponse);//跳转回登入页
        }else {//已经登入过了
            filterChain.doFilter(servletRequest,servletResponse);
        }
    }

    public void destroy() {
        System.out.println("过滤器销毁！");
    }
}
