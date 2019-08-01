package com.demo.controller;

import com.demo.dao.Message;
import com.demo.dao.SelectMessage;
import com.demo.dao.UpdateMessage;

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

public class EditSuccessServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        Date date=new Date();
        DateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        SelectMessage selectMessage=new SelectMessage();
        UpdateMessage updateMessage=new UpdateMessage();

        String date_edit=dateFormat.format(date);
        String messageid = req.getParameter("messageid");
        Message message = selectMessage.selectById(Integer.valueOf(messageid));
        //System.out.println(message.getId()+"*"+message.getLabel());
        String label = req.getParameter("label");
        String detail = req.getParameter("detail");
        message.setLabel(label);
        message.setDetail(detail);
        message.setDate_edit(date_edit);
        updateMessage.update(message);

        List<Message> messages = selectMessage.selectAll();
        HttpSession session = req.getSession();
        session.setAttribute("messageSet",messages);

        resp.sendRedirect("message.jsp");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
}
