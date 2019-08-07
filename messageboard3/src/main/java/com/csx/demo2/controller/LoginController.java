package com.csx.demo2.controller;

import com.csx.demo2.entity.Result;
import com.csx.demo2.service.LoginService;
import com.csx.demo2.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@Controller
public class LoginController {


    @Autowired
    private LoginService loginService;

    @Autowired
    private PermissionService permissionService;

    @RequestMapping("LoginController")
    public String logincontroller(HttpServletRequest req) throws IOException {
        HttpSession session = req.getSession();
        req.setCharacterEncoding("UTF-8");
        String username=req.getParameter("username");//获取用户名
        String password=req.getParameter("password");//获取密码
        System.out.println("登入用户:"+username);//控制台输出用户名
        System.out.println("密码:"+password);//控制台输出密码

        Result loginverify = loginService.loginverify(username, password);//验证
        if(loginverify.isResult()){//验证成功
            permissionService.removeSessionPermission(session);
            //List<Message> messages = messageService.selectAllMessage();
            session.setAttribute("messageSet",loginverify.getMessages());//把消息对象添加到session域
            session.setAttribute("user",loginverify.getUser());//把用户传到session域
            session.setAttribute("pageBean",loginverify.getPageBean());//把页面对象加到session域
            session.removeAttribute("error");//
            session.setAttribute("permissions",loginverify.getPermissions());
            permissionService.addSessionPermission(session,loginverify.getPermissions());
            return "message";
        }else{//验证失败
            session.setAttribute("error","用户或者密码错误！");
            return "login";
        }

    }
}
