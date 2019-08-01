package com.demo.controller;

import com.demo.dao.Message;
import com.demo.dao.SelectMessage;
import com.demo.dao.SelectUser;
import com.demo.dao.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

public class AllUserServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        SelectUser selectUser=new SelectUser();
        SelectMessage selectMessage=new SelectMessage();
        List<User> users = selectUser.selectAll();
        Iterator<User> it=users.iterator();
        while(it.hasNext()){
            User next = it.next();
            System.out.println(next.getId());
            List<Message> messages = selectMessage.selectByUserId(next.getId());
            next.setCount_message(messages.size());
        }
        session.setAttribute("users",users);
        resp.sendRedirect("users.jsp");
    }
}
