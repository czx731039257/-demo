package com.csx.demo2.filter;


import com.csx.demo2.entity.Permission;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


@WebFilter(urlPatterns = {"/message","/create","/edit","/editperson","/person","/users","/edituser","/permission","/roles","/users"}, filterName = "authFilter")
public class MyFilter implements Filter {
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("过滤器初始化*******************");
    }

    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request=(HttpServletRequest)servletRequest;
        HttpSession session = request.getSession();//获取session域
        if(session.getAttribute("user")==null){//还未登入
            System.out.println("过滤器判定你还没登入，跳到登入页面********************");
            ((HttpServletResponse)servletResponse).sendRedirect("login");//跳转回登入页
        }else {//已经登入过了，但是要判断是否有该页面的访问权限
                System.out.println("过滤器判定你已经登入，进入操作页面********************");
                filterChain.doFilter(servletRequest, servletResponse);
        }
    }

    public void destroy() {
        System.out.println("过滤器销毁*******************************");
    }

}
