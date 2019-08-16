package com.csx.demo2.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationException;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@Controller
public class testController {

    @RequestMapping("/testcontroller1")
    public String testcontroller1(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        String referer = req.getHeader("Referer");
        System.out.println("***************");
        System.out.println(referer);
        int i = referer.lastIndexOf('/')+1;
        referer=referer.substring(i);
        System.out.println(referer);
        HttpSession session = req.getSession();
        session.setAttribute("withoutPermission","true");
        return "redirect:"+referer;
    }

    @RequestMapping("/testcontroller2")
    public String testcontroller2(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        String[] str={"a","b","c","d"};
        req.getSession().setAttribute("str",str);
        return "redirect:"+"test1";
    }
    @RequestMapping("/testlogin")
    public String testlogin(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        UsernamePasswordToken token=new UsernamePasswordToken(username,password);
        Subject subject = SecurityUtils.getSubject();
        if(subject.isAuthenticated()){
           return "test1";
        }else{
            try {
                subject.login(token);
                return "test1";
            } catch (AuthenticationException e) {
                e.printStackTrace();
                return "test2";
            }
        }
    }

    @RequiresRoles({"role"})
    @RequiresPermissions({"select"})
    @RequestMapping("/permission1")
    public String permission1(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        System.out.println("你有该权限");
        String[] str={"a","b","c","d"};
        req.getSession().setAttribute("str",str);
        return "redirect:"+"test1";
    }

    @ExceptionHandler({AuthorizationException.class})
    public String exce(HttpServletRequest req){
        System.out.println("你没有该权限");
        return "redirect:"+"test1";
    }
}
