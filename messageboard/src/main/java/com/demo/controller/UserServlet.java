package com.demo.controller;

import com.demo.dao.Message;
import com.demo.dao.SelectMessage;
import com.demo.dao.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

public class UserServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        HttpSession session = req.getSession();
        User user = (User) session.getAttribute("user");
        SelectMessage selectMessage = new SelectMessage();
        List<Message> messages = selectMessage.selectByUserId(user.getId());
        user.setCount_message(messages.size());
        session.setAttribute("user", user);
        resp.sendRedirect("usermessage.jsp");
    }
}
