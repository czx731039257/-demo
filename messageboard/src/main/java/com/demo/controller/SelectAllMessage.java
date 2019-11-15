package com.demo.controller;

import com.demo.dao.Message;
import com.demo.dao.PageBean;
import com.demo.dao.SelectMessage;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

public class SelectAllMessage extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        HttpSession session = req.getSession();
        SelectMessage selectMessage = new SelectMessage();
        PageBean pageBean = (PageBean) session.getAttribute("pageBean");
        List<Message> messages = selectMessage.selectAll();
        PageBean pageBean1 = new PageBean(1, 10, messages.size());
        session.setAttribute("messageSet", messages);
        session.setAttribute("pageBean", pageBean1);
        resp.sendRedirect("message.jsp");
    }
}
