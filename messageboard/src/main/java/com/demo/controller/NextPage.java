package com.demo.controller;

import com.demo.dao.PageBean;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class NextPage extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        PageBean pageBean = (PageBean) session.getAttribute("pageBean");
        pageBean.addPageNumber();

        session.setAttribute("pageBean", pageBean);
        //req.getRequestDispatcher("message.jsp").forward(req,resp);
        resp.sendRedirect("message.jsp");
    }
}
