package com.demo.controller;

import com.demo.dao.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Set;

public class CreateServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        HttpSession session = req.getSession();
        User user = (User) session.getAttribute("user");
        Date date = new Date();
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        InsertMessage insertMessage = new InsertMessage();
        SelectMessage selectMessage = new SelectMessage();

        int user_id = user.getId();
        String label = req.getParameter("label");
        String detail = req.getParameter("detail");
        String date_create = dateFormat.format(date);
        String date_edit = dateFormat.format(date);

        Message message = new Message(label, detail, date_create, date_edit, user_id);
        insertMessage.insert(message);//创建新的留言

        List<Message> messages = selectMessage.selectAll();//查询所有留言
        PageBean pageBean = (PageBean) session.getAttribute("pageBean");
        pageBean.addTotalRecord();

        session.setAttribute("messageSet", messages);
        //req.getRequestDispatcher("message.jsp").forward(req,resp);
        resp.sendRedirect("message.jsp");
    }
}
