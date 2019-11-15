package com.demo.controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class EditServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String messageid = req.getParameter("messageid");
        req.setAttribute("messageid", messageid);
        //req.getRequestDispatcher("edit.jsp").forward(req,resp);
        resp.sendRedirect("edit.jsp");
    }
}
