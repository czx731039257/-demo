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
    public String LoginController(HttpServletRequest req) throws IOException {
        HttpSession session = req.getSession();
        req.setCharacterEncoding("UTF-8");
        String username=req.getParameter("username");//获取用户名
        String password=req.getParameter("password");//获取密码
        //System.out.println("登入用户:"+username);//控制台输出用户名
        //System.out.println("密码:"+password);//控制台输出密码

        Result result = loginService.loginverify(username, password);//验证
        if(result.isResult()){//验证成功
            permissionService.removeSessionPermission(session);
            session.setAttribute("logmsg","登入成功");
            session.setAttribute("messageSet",result.getMessages());//把 留言对象的集合 添加到session域
            session.setAttribute("user",result.getUser());//把 用户对象 传到session域
            session.setAttribute("pageBean",result.getPageBean());//把 分页 对象加到session域
            session.removeAttribute("error");//移出错误信息信息
            session.setAttribute("permissions",result.getPermissions());//把 权限集合 添加到session域
            permissionService.addSessionPermission(session,result.getPermissions());//
            return "redirect:"+"message";//返回前端
        }else{//验证失败
            session.setAttribute("logmsg","登入失败");
            session.setAttribute("error","用户或者密码错误！");
            return "redirect:"+"login";
        }

    }
}
