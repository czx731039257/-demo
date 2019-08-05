package com.csx.demo2.controller;

import com.csx.demo2.dao.MessageDao;
import com.csx.demo2.dao.UserDao;
import com.csx.demo2.entity.Message;
import com.csx.demo2.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Iterator;
import java.util.List;

@Controller
public class UserController {
    @Autowired
    private UserDao userDao;

    @Autowired
    private MessageDao messageDao;

    @RequestMapping("SelectAllUserInfoController")
    public String allusercontroller(HttpServletRequest req) throws ServletException, IOException {
        HttpSession session = req.getSession();
        List<User> users = userDao.select(new User());
        Iterator<User> it=users.iterator();
        while(it.hasNext()){
            User next = it.next();
            System.out.println(next.getId());
            List<Message> messages = messageDao.select(new Message(0,null,null,null,null,next.getId()));
            next.setCount_message(messages.size());
        }
        session.setAttribute("users",users);
        return "users";
    }

    @RequestMapping("PersonInfoController")
    public String usercontroller(HttpServletRequest req) throws UnsupportedEncodingException {
        req.setCharacterEncoding("UTF-8");
        HttpSession session = req.getSession();
        User user = (User)session.getAttribute("user");
        List<Message> messages = messageDao.select(new Message(0,null,null,null,null,user.getId()));
        user.setCount_message(messages.size());
        session.setAttribute("user",user);
        return "person";
    }

    @RequestMapping("EditPersonInfoController")
    public String editusercontroller(HttpServletRequest req) throws UnsupportedEncodingException {
            req.setCharacterEncoding("UTF-8");
            HttpSession session = req.getSession();
            String id = req.getParameter("id");
            String name = req.getParameter("name");
            String password = req.getParameter("password");
            String email = req.getParameter("email");
            String phone = req.getParameter("phone");
            int conut_message = ((User) session.getAttribute("user")).getCount_message();
            User user=new User(Integer.valueOf(id),name,password,email,phone,conut_message);
            userDao.update(user);
            session.setAttribute("user",user);
            return "person";
    }

    @RequestMapping("CancelUserController")
    public String cancelcontroller(HttpServletRequest req) throws UnsupportedEncodingException {
        req.setCharacterEncoding("UTF-8");
        HttpSession session = req.getSession();
        session.removeAttribute("user");//从session域中删除user
        return "login";
    }

}
