package com.demo.controller;

import com.demo.dao.UpdateUser;
import com.demo.dao.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class EditUser extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        HttpSession session = req.getSession();
        String id = req.getParameter("id");
        String name = req.getParameter("name");
        String password = req.getParameter("password");
        String email = req.getParameter("email");
        String phone = req.getParameter("phone");
        int conut_message = ((User) session.getAttribute("user")).getCount_message();
        User user = new User(Integer.valueOf(id), name, password, email, phone, conut_message);
        UpdateUser updateUser = new UpdateUser();
        updateUser.update(user);

        session.setAttribute("user", user);
        resp.sendRedirect("usermessage.jsp");
    }
}
