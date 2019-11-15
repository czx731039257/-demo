package com.demo.controller;

import com.demo.dao.DeleteMessage;
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
import java.util.Set;

public class DeleteServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String messageid = req.getParameter("messageid");//获取要删除的留言id
        HttpSession session = req.getSession();
        DeleteMessage deleteMessage = new DeleteMessage();
        SelectMessage selectMessage = new SelectMessage();

        deleteMessage.delete(Integer.valueOf(messageid).intValue());//执行删除操作
        List<Message> messages = selectMessage.selectAll();//查找所有留言
        session.setAttribute("messageSet", messages);
        PageBean pageBean1 = (PageBean) session.getAttribute("pageBean");
        int totalRecord = messages.size();
        System.out.println(totalRecord);
        PageBean pageBean = new PageBean(pageBean1.getPageNumber(), 4, totalRecord);
        session.setAttribute("pageBean", pageBean);

        //req.getRequestDispatcher("message.jsp").forward(req,resp);
        resp.sendRedirect("message.jsp");
    }
}
