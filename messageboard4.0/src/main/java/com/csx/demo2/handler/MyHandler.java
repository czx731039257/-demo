package com.csx.demo2.handler;

import com.csx.demo2.entity.Permission;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Iterator;
import java.util.List;

public class MyHandler implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String referer = request.getHeader("REFERER");
        if (referer == null) {
            //System.out.println("请不要跳过按键自己访问页面");
            request.getSession().setAttribute("accesserror", "true");
            request.getRequestDispatcher("message").forward(request, response);
            return false;
        }
        int i = referer.lastIndexOf('/');
        referer = referer.substring(i + 1);
        String requestURI = request.getRequestURI();
        i = requestURI.lastIndexOf('/');
        requestURI = requestURI.substring(i + 1);
        //System.out.println("来源页面：" + referer);
        //System.out.println("拦截了：" + requestURI);
        if (isHasThisPermission(request, requestURI))
            return true;
        else {
            request.getSession().setAttribute("withoutPermission", "true");
            response.sendRedirect(referer);
            return false;
        }
    }

    public boolean isHasThisPermission(HttpServletRequest request, String requestURI) {
        HttpSession session = request.getSession();
        List<Permission> permissions = (List<Permission>) session.getAttribute("permissions");
        if (requestURI.equals("SelectPersonMessageController") && traverse(14, permissions))
            return true;
        else if (requestURI.equals("SelectGroupMessageController") && traverse(15, permissions))
            return true;
        else if (requestURI.equals("SelectOtherGroupMessageController") && traverse(16, permissions))
            return true;
        else if (requestURI.equals("SelectAllMessageController") && traverse(14, permissions) && traverse(15, permissions) && traverse(16, permissions))
            return true;
        else if (requestURI.equals("CreateMessageController") && traverse(7, permissions))
            return true;
        else if (requestURI.equals("PersonInfoController") && traverse(4, permissions))
            return true;
        else if (requestURI.equals("SelectGroupUserInfoController") && traverse(5, permissions))
            return true;
        else if (requestURI.equals("SelectOtherGroupUserInfoController") && traverse(6, permissions))
            return true;
        else if (requestURI.equals("SelectAllUserInfoController") && traverse(4, permissions) && traverse(5, permissions) && traverse(6, permissions))
            return true;
        else if (requestURI.equals("allocationcontroller") && traverse(17, permissions))
            return true;
        else if (requestURI.equals("EditPersonInfoSuccessController") && traverse(1, permissions))
            return true;
        else if (requestURI.equals("selectrole") && traverse(17, permissions))
            return true;
        else if (requestURI.equals("editrolesuccesscontroller") && traverse(17, permissions))
            return true;
        else if (requestURI.equals("editpermissioncontroller") && traverse(17, permissions))
            return true;
        else if (requestURI.equals("editpermissionsuccess") && traverse(17, permissions))
            return true;
        else if (requestURI.equals("create") && traverse(7, permissions))
            return true;
        else if (requestURI.equals("allocation") && traverse(17, permissions))
            return true;
        else if (requestURI.equals("permission") && traverse(17, permissions))
            return true;
        else if (requestURI.equals("roles") && traverse(17, permissions))
            return true;
        else if (requestURI.equals("editrole") && traverse(17, permissions))
            return true;
        else
            return false;
    }

    public boolean traverse(int permissionid, List<Permission> permissions) {
        Iterator<Permission> it = permissions.iterator();
        while (it.hasNext()) {
            if (it.next().getId() == permissionid)
                return true;
        }
        return false;
    }


    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
