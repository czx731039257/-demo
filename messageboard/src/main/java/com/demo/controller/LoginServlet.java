package com.demo.controller;

import com.demo.dao.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String username = req.getParameter("username");//获取用户名
        String password = req.getParameter("password");//获取密码
        //System.out.println(username);
        //System.out.println(password);

        SelectUser selectUser = new SelectUser();
        SelectMessage selectMessage = new SelectMessage();
        Set<User> check = selectUser.select(username, password);

        HttpSession session = req.getSession();
        if (check.size() == 1) {//登入成功
            User user = null;
            System.out.println("登入成功！");
            Iterator<User> it = check.iterator();
            while (it.hasNext()) {//获取用户对象
                user = it.next();
            }
            //int userid = user.getId();//获取用户id  方便接下来查找留言
            List<Message> messageSet = selectMessage.selectAll();
            int totalRecord = messageSet.size();
            System.out.println(totalRecord);
            PageBean pageBean = new PageBean(1, 4, totalRecord);

            session.setAttribute("messageSet", messageSet);//把消息对象添加到session域中
            session.setAttribute("user", user);//把用户传到session域
            session.setAttribute("pageBean", pageBean);

            //req.getRequestDispatcher("message.jsp").forward(req,resp);
            resp.sendRedirect("message.jsp");
        } else {//登入失败
            System.out.println("登入失败！");
            req.setAttribute("error", "用户或者密码错误！");
            //req.getRequestDispatcher("login.jsp").forward(req,resp);
            resp.sendRedirect("login.jsp");
        }
    }
}
