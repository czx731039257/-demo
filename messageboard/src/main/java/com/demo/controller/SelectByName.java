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

public class SelectByName extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String name = req.getParameter("name");

        HttpSession session = req.getSession();
        SelectMessage selectMessage = new SelectMessage();
        List<Message> messages = selectMessage.selectByUserName(name);
        PageBean pageBean = new PageBean(1, 10, messages.size());
        //System.out.println(pageBean.getPageNumber()+"---"+pageBean.getStartIndex()+"---"+pageBean.getEndIndex());
        session.setAttribute("messageSet", messages);
        session.setAttribute("pageBean", pageBean);
        resp.sendRedirect("message.jsp");
    }
}
