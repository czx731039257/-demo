package com.csx.demo2.controller;

import com.csx.demo2.entity.Result;
import com.csx.demo2.service.LoginService;
import com.csx.demo2.service.PermissionService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@Controller
public class LoginAction {


    @Autowired
    private LoginService loginService;


    /**
     * 登入时的验证
     * @param req
     * @return
     * @throws IOException
     */
    @RequestMapping("loginVerify")
    public String loginVerify(HttpServletRequest req) throws IOException {
        HttpSession session = req.getSession();
        req.setCharacterEncoding("UTF-8");
        String username=req.getParameter("username");//获取用户名
        String password=req.getParameter("password");//获取密码
        if(username.equals("")||password.equals("")){
            session.setAttribute("error","用户名和密码不能为空！");
            return "redirect:"+"login";
        }


        UsernamePasswordToken token=new UsernamePasswordToken(username,password);
        Subject subject = SecurityUtils.getSubject();
        if(!subject.isAuthenticated()){//还没登入
            try {
                subject.login(token);
            } catch (AuthenticationException e) {//捕获登入失败的异常
                e.printStackTrace();
                session.setAttribute("loginerror","用户名或密码错误");
                return "redirect:"+"login";
            }

            Result userInfo = loginService.getUserInfo(username);
            session.setAttribute("messageSet",userInfo.getMessages());//把 留言对象的集合 添加到session域
            session.setAttribute("user",userInfo.getUser());//把 用户对象 传到session域
            session.setAttribute("pageBean",userInfo.getPageBean());//把 分页 对象加到session域
            session.removeAttribute("loginerror");//移出错误信息
            session.setAttribute("permissions",userInfo.getPermissions());//把 权限集合 添加到session域


            return "redirect:"+"message";
        }else{//已经登入过了
            return "redirect:"+"message";//返回前端
        }

    }
}
