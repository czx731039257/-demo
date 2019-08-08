package com.csx.demo2.filter;


import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


@WebFilter(urlPatterns = {"/message","/create","/edit","/editperson","/person","/users","/edituser","/permission","/roles","/users","/SelectOtherGroupMessageController",
"/SelectPersonMessageController",
"/SelectGroupMessageController",
"/SelectAllMessageController",
"/SelectAllUserInfoController",
"/PersonInfoController",
"/EditPersonInfoSuccessController",
"/SelectGroupUserInfoController",
"/SelectOtherGroupUserInfoController",
"/allocationcontroller"}, filterName = "authFilter")
public class MyFilter implements javax.servlet.Filter {
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("过滤器初始化*******************");
    }

    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("拦截请求**************************************");
        HttpServletRequest request=(HttpServletRequest)servletRequest;
        HttpSession session = request.getSession();//获取session域
        //String referer = request.getHeader("Referer");
        System.out.println("上一个页面的地址："+"-------------");
        //int i = referer.lastIndexOf('/')+1;
        //referer=referer.substring(i);
        //System.out.println("referer:"+referer);
        String requestURI = request.getRequestURI();
        System.out.println(requestURI);
        int i = requestURI.indexOf("/", 1);
        String substring = requestURI.substring(i+1);
        System.out.println(substring);
        if(session.getAttribute("user")==null){//还未登入
            System.out.println("过滤器判定你还没登入，跳到登入页面********************");
            ((HttpServletResponse)servletResponse).sendRedirect("login");//跳转回登入页
        }else {//已经登入过了，但是要判断是否有该页面的访问权限

            if("SelectOtherGroupMessageController".equals(substring)) {
                Boolean check = (Boolean) session.getAttribute("canSelectOtherGroupMessage");
                if (check != null && check == true)//有权限
                    filterChain.doFilter(servletRequest, servletResponse);
                else {//没有权限
                    session.setAttribute("withoutPermission", "true");
                    ((HttpServletResponse) servletResponse).sendRedirect("message");
                }
            }else if("SelectPersonMessageController".equals(substring)) {
                Boolean check = (Boolean) session.getAttribute("canSelectPersonMessage");
                if (check != null && check == true)//有权限
                    filterChain.doFilter(servletRequest, servletResponse);
                else {//没有权限
                    session.setAttribute("withoutPermission", "true");
                    ((HttpServletResponse) servletResponse).sendRedirect("message");
                }
            }else if("SelectGroupMessageController".equals(substring)) {
                Boolean check = (Boolean) session.getAttribute("canSelectGroupMessage");
                if (check != null && check == true)//有权限
                    filterChain.doFilter(servletRequest, servletResponse);
                else {//没有权限
                    session.setAttribute("withoutPermission", "true");
                    ((HttpServletResponse) servletResponse).sendRedirect("message");
                }
            }else if("SelectAllMessageController".equals(substring)) {
                Boolean check1 = (Boolean) session.getAttribute("canSelectPersonMessage");
                Boolean check2 = (Boolean) session.getAttribute("canSelectGroupMessage");
                Boolean check3 = (Boolean) session.getAttribute("canSelectOtherGroupMessage");
                if (check1 != null && check1 == true &&check2 != null && check2 == true && check3 != null && check3 == true)//有权限
                    filterChain.doFilter(servletRequest, servletResponse);
                else {//没有权限
                    session.setAttribute("withoutPermission", "true");
                    ((HttpServletResponse) servletResponse).sendRedirect("message");
                }
            }else if("SelectAllUserInfoController".equals(substring)) {
                Boolean check1 = (Boolean) session.getAttribute("canSelectPersonInfo");
                Boolean check2 = (Boolean) session.getAttribute("canSelectGroupInfo");
                Boolean check3 = (Boolean) session.getAttribute("canSelectOtherGroupInfo");
                if (check1 != null && check1 == true &&check2 != null && check2 == true && check3 != null && check3 == true)//有权限
                    filterChain.doFilter(servletRequest, servletResponse);
                else {//没有权限
                    session.setAttribute("withoutPermission", "true");
                    ((HttpServletResponse) servletResponse).sendRedirect("message");
                }
            }else if("PersonInfoController".equals(substring)) {
                Boolean check = (Boolean) session.getAttribute("canSelectPersonInfo");
                if (check != null && check == true)//有权限
                    filterChain.doFilter(servletRequest, servletResponse);
                else {//没有权限
                    session.setAttribute("withoutPermission", "true");
                    ((HttpServletResponse) servletResponse).sendRedirect("message");
                }
            }else if("EditPersonInfoSuccessController".equals(substring)) {
                Boolean check = (Boolean) session.getAttribute("canEditPersonInfo");
                if (check != null && check == true)//有权限
                    filterChain.doFilter(servletRequest, servletResponse);
                else {//没有权限
                    session.setAttribute("withoutPermission", "true");
                    ((HttpServletResponse) servletResponse).sendRedirect("users");
                }
            }else if("SelectGroupUserInfoController".equals(substring)) {
                Boolean check = (Boolean) session.getAttribute("canSelectGroupInfo");
                if (check != null && check == true)//有权限
                    filterChain.doFilter(servletRequest, servletResponse);
                else {//没有权限
                    session.setAttribute("withoutPermission", "true");
                    ((HttpServletResponse) servletResponse).sendRedirect("message");
                }
            }else if("SelectOtherGroupUserInfoController".equals(substring)) {
                Boolean check = (Boolean) session.getAttribute("canSelectOtherGroupInfo");
                if (check != null && check == true)//有权限
                    filterChain.doFilter(servletRequest, servletResponse);
                else {//没有权限
                    session.setAttribute("withoutPermission", "true");
                    ((HttpServletResponse) servletResponse).sendRedirect("message");
                }
            }else if("allocationcontroller".equals(substring)) {
                Boolean check = (Boolean) session.getAttribute("canAllocationRole");
                if (check != null && check == true)//有权限
                    filterChain.doFilter(servletRequest, servletResponse);
                else {//没有权限
                    session.setAttribute("withoutPermission", "true");
                    ((HttpServletResponse) servletResponse).sendRedirect("message");
                }
            }else if("allocationcontroller".equals(substring)) {
                Boolean check = (Boolean) session.getAttribute("canAllocationRole");
                if (check != null && check == true)//有权限
                    filterChain.doFilter(servletRequest, servletResponse);
                else {//没有权限
                    session.setAttribute("withoutPermission", "true");
                    ((HttpServletResponse) servletResponse).sendRedirect("message");
                }
            }else if("allocationcontroller".equals(substring)) {
                Boolean check = (Boolean) session.getAttribute("canAllocationRole");
                if (check != null && check == true)//有权限
                    filterChain.doFilter(servletRequest, servletResponse);
                else {//没有权限
                    session.setAttribute("withoutPermission", "true");
                    ((HttpServletResponse) servletResponse).sendRedirect("message");
                }
            }else if("allocationcontroller".equals(substring)) {
                Boolean check = (Boolean) session.getAttribute("canAllocationRole");
                if (check != null && check == true)//有权限
                    filterChain.doFilter(servletRequest, servletResponse);
                else {//没有权限
                    session.setAttribute("withoutPermission", "true");
                    ((HttpServletResponse) servletResponse).sendRedirect("message");
                }
            }




            else{

                System.out.println("过滤器判定你已经登入，进入操作页面********************");
                filterChain.doFilter(servletRequest, servletResponse);
            }
        }
    }

    public void destroy() {
        System.out.println("过滤器销毁*******************************");
    }

}
