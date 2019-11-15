package com.csx.demo2.controller;

import com.csx.demo2.entity.Result;
import com.csx.demo2.entity.VerifyResult;
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
    public String LoginController(HttpServletRequest req) throws IOException {
        HttpSession session = req.getSession();
        req.setCharacterEncoding("UTF-8");
        String username = req.getParameter("username");//获取用户名
        String password = req.getParameter("password");//获取密码
        if (username.equals("") || password.equals("")) {
            session.setAttribute("loginflag", Integer.valueOf(-1));
            session.setAttribute("logmsg", "失败");
            session.setAttribute("error", "用户名和密码不能为空！");
            return "redirect:" + "login";
        }
        //Result result = loginService.loginverify(username, password);//验证
        VerifyResult result = loginService.loginverify(username, password);
        if (result.getFlag() == 2) {//验证成功
            permissionService.removeSessionPermission(session);
            session.setAttribute("loginflag", result.getFlag());
            session.setAttribute("logmsg", "成功");
            session.setAttribute("messageSet", result.getMessages());//把 留言对象的集合 添加到session域
            session.setAttribute("user", result.getUser());//把 用户对象 传到session域
            session.setAttribute("pageBean", result.getPageBean());//把 分页 对象加到session域
            session.removeAttribute("error");//移出错误信息信息
            session.setAttribute("permissions", result.getPermissions());//把 权限集合 添加到session域
            permissionService.addSessionPermission(session, result.getPermissions());//
            return "redirect:" + "message";//返回前端
        } else if (result.getFlag() == 1) {//验证失败
            session.setAttribute("loginflag", result.getFlag());
            session.setAttribute("failuser", result.getUser());
            session.setAttribute("logmsg", "失败");
            session.setAttribute("error", "密码错误！");
            return "redirect:" + "login";
        } else {
            session.setAttribute("loginflag", result.getFlag());
            session.setAttribute("logmsg", "失败");
            session.setAttribute("error", "用户不存在！");
            return "redirect:" + "login";
        }

    }
}
