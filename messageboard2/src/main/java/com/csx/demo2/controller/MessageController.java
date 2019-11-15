package com.csx.demo2.controller;

import com.csx.demo2.dao.MessageDao;
import com.csx.demo2.dao.UserDao;
import com.csx.demo2.entity.Message;
import com.csx.demo2.entity.PageBean;
import com.csx.demo2.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.UnsupportedEncodingException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


@Controller
public class MessageController {
    @Autowired
    private UserDao userDao;

    @Autowired
    private MessageDao messageDao;

    @RequestMapping("SelectMessageByUserNameController")
    public String selectbynamecontroller(HttpServletRequest req) throws UnsupportedEncodingException {
        req.setCharacterEncoding("UTF-8");
        String name = req.getParameter("name");
        HttpSession session = req.getSession();

        List<Message> messages = messageDao.selectByUserName(name);
        PageBean pageBean = new PageBean(1, 10, messages.size());
        //System.out.println(pageBean.getPageNumber()+"---"+pageBean.getStartIndex()+"---"+pageBean.getEndIndex());
        session.setAttribute("messageSet", messages);
        session.setAttribute("pageBean", pageBean);
        return "message";
    }

    @RequestMapping("SelectAllMessageController")
    public String selectallcontroller(HttpServletRequest req) throws UnsupportedEncodingException {
        req.setCharacterEncoding("UTF-8");
        HttpSession session = req.getSession();
        PageBean pageBean = (PageBean) session.getAttribute("pageBean");
        List<Message> messages = messageDao.select(new Message(0, null, null, null, null, 0));
        PageBean pageBean1 = new PageBean(1, 10, messages.size());
        session.setAttribute("messageSet", messages);
        session.setAttribute("pageBean", pageBean1);
        return "message";
    }

    @RequestMapping("CreateMessageController")
    public String createcontroller(HttpServletRequest req) throws UnsupportedEncodingException {
        req.setCharacterEncoding("UTF-8");
        HttpSession session = req.getSession();
        User user = (User) session.getAttribute("user");
        Date date = new Date();
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");

        int user_id = user.getId();
        String label = req.getParameter("label");
        String detail = req.getParameter("detail");
        String date_create = dateFormat.format(date);
        String date_edit = dateFormat.format(date);

        Message message = new Message(label, detail, date_create, date_edit, user_id);
        messageDao.insert(message);//创建新的留言

        List<Message> messages = messageDao.select(new Message(0, null, null, null, null, 0));//查询所有留言
        PageBean pageBean = (PageBean) session.getAttribute("pageBean");
        pageBean.addTotalRecord();

        session.setAttribute("messageSet", messages);
        return "message";
    }

    @RequestMapping("DeleteMessageController")
    public String deletecontroller(HttpServletRequest req) throws UnsupportedEncodingException {
        req.setCharacterEncoding("UTF-8");
        String messageid = req.getParameter("messageid");//获取要删除的留言id
        HttpSession session = req.getSession();

        messageDao.deleteById(Integer.valueOf(messageid));//执行删除操作
        List<Message> messages = messageDao.select(new Message(0, null, null, null, null, 0));//查找所有留言
        session.setAttribute("messageSet", messages);
        PageBean pageBean1 = (PageBean) session.getAttribute("pageBean");
        int totalRecord = messages.size();
        //System.out.println(totalRecord);
        PageBean pageBean = new PageBean(pageBean1.getPageNumber(), 10, totalRecord);
        session.setAttribute("pageBean", pageBean);
        return "message";
    }

    @RequestMapping("IntoEditMessageController")
    public String editcontroller(HttpServletRequest req) throws UnsupportedEncodingException {
        req.setCharacterEncoding("UTF-8");
        String messageid = req.getParameter("messageid");
        req.setAttribute("messageid", messageid);
        List<Message> list = messageDao.select(new Message(Integer.valueOf(messageid), null, null, null, null, 0));
        Message message = list.get(0);
        req.setAttribute("message", message);
        //req.getRequestDispatcher("edit.jsp").forward(req,resp);
        //resp.sendRedirect("edit.jsp");
        return "edit";
    }

    @RequestMapping("EditMessageSuccessController")
    public String editsuccesscontroller(HttpServletRequest req) throws UnsupportedEncodingException {
        req.setCharacterEncoding("UTF-8");
        Date date = new Date();
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");

        String date_edit = dateFormat.format(date);
        String messageid = req.getParameter("messageid");
        List<Message> select = messageDao.select(new Message(Integer.valueOf(messageid), null, null, null, null, 0));
        Message message = select.get(0);

        String label = req.getParameter("label");
        String detail = req.getParameter("detail");
        message.setLabel(label);
        message.setDetail(detail);
        message.setDate_edit(date_edit);
        messageDao.update(message);

        List<Message> messages = messageDao.select(new Message(0, null, null, null, null, 0));
        HttpSession session = req.getSession();
        session.setAttribute("messageSet", messages);
        return "message";
    }
}
