package com.demo.sis.controller;

import com.demo.sis.dao.UserDao;
import com.demo.sis.entity.Result;
import com.demo.sis.entity.User;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class LoginAction {

    @Autowired
    private UserDao userDao;

    @ResponseBody
    @RequestMapping("loginVerify")
    public Result loginVerify(HttpServletRequest req) {
        HttpSession session = req.getSession();
        String name = req.getParameter("loginName");
        String pwd = req.getParameter("loginPwd");

        UsernamePasswordToken token = new UsernamePasswordToken(name, pwd);
        Subject subject = SecurityUtils.getSubject();
        if (!subject.isAuthenticated()) {//还没登入
            try {
                subject.login(token);
            } catch (AuthenticationException e) {//捕获登入失败的异常
                e.printStackTrace();
                //session.setAttribute("errorMsg","用户名或密码错误");
                return new Result.Builder().errorMsg("用户名或密码错误").backUrl("login").build();
            }
            User user = userDao.select(new User.Builder().username(name).build()).get(0);
            session.setAttribute("user", user);
            return new Result.Builder().successMsg("登入成功").backUrl("homepage").build();
        } else {//已经登入过了
            return new Result.Builder().successMsg("已经登入过").backUrl("homepage").build();
        }


    }
}
