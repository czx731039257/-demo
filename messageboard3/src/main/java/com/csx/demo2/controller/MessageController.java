package com.csx.demo2.controller;

import com.csx.demo2.entity.Message;
import com.csx.demo2.entity.PageBean;
import com.csx.demo2.entity.Result;
import com.csx.demo2.entity.User;
import com.csx.demo2.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.UnsupportedEncodingException;


@Controller
public class MessageController {

    @Autowired
    private MessageService messageService;

    @RequestMapping("SelectMessageByUserNameController")
    public String selectbynamecontroller(HttpServletRequest req) throws UnsupportedEncodingException {
        req.setCharacterEncoding("UTF-8");
        String name = req.getParameter("name");
        HttpSession session = req.getSession();

        Result result = messageService.selectMessageByUserName(name);//调用业务层

        session.setAttribute("messageSet",result.getMessages());
        session.setAttribute("pageBean",result.getPageBean());
        return "message";
    }


    @RequestMapping("SelectPersonMessageController")
    public String SelectPersonMessageController(HttpServletRequest req) throws UnsupportedEncodingException {
        req.setCharacterEncoding("UTF-8");
        HttpSession session = req.getSession();
        User user = (User)session.getAttribute("user");

        Result result = messageService.selectPersonMessage(user);//调用业务层

        session.setAttribute("messageSet",result.getMessages());
        session.setAttribute("pageBean",result.getPageBean());
        return "message";
    }


    @RequestMapping("SelectGroupMessageController")
    public String SelectGroupMessageController(HttpServletRequest req) throws UnsupportedEncodingException {
        req.setCharacterEncoding("UTF-8");
        HttpSession session = req.getSession();
        User user = (User)session.getAttribute("user");

        Result result = messageService.selectGroupMessage(user);//调用业务层

        session.setAttribute("messageSet",result.getMessages());
        session.setAttribute("pageBean",result.getPageBean());
        return "message";
    }

    @RequestMapping("SelectOtherGroupMessageController")
    public String SelectGroupOtherMessageController(HttpServletRequest req) throws UnsupportedEncodingException {
        req.setCharacterEncoding("UTF-8");
        HttpSession session = req.getSession();
        User user = (User)session.getAttribute("user");

        Result result = messageService.selectOtherGroupMessage(user);//调用业务层

        session.setAttribute("messageSet",result.getMessages());
        session.setAttribute("pageBean",result.getPageBean());
        return "message";
    }
    @RequestMapping("SelectAllMessageController")
    public String selectallcontroller(HttpServletRequest req) throws UnsupportedEncodingException {
        req.setCharacterEncoding("UTF-8");
        HttpSession session = req.getSession();

        Result result = messageService.selectAllMessage();//调用业务层

        session.setAttribute("messageSet",result.getMessages());
        session.setAttribute("pageBean",result.getPageBean());
        return "message";
    }
    @RequestMapping("CreateMessageController")
    public String createcontroller(HttpServletRequest req) throws UnsupportedEncodingException {
        req.setCharacterEncoding("UTF-8");
        HttpSession session = req.getSession();
        User user = (User)session.getAttribute("user");
        String label = req.getParameter("label");
        String detail = req.getParameter("detail");
        PageBean pageBean = (PageBean)session.getAttribute("pageBean");

        Result result = messageService.createMessage(pageBean, user, label, detail);//调用业务层

        session.setAttribute("pageBean",result.getPageBean());
        session.setAttribute("messageSet",result.getMessages());
        return "message";
    }
    @RequestMapping("DeleteMessageController")
    public String deletecontroller(HttpServletRequest req) throws UnsupportedEncodingException {
        req.setCharacterEncoding("UTF-8");
        String messageid = req.getParameter("messageid");//获取要删除的留言id
        HttpSession session = req.getSession();
        PageBean pageBean = (PageBean)session.getAttribute("pageBean");
        User user = (User)session.getAttribute("user");
        Result result = messageService.deleteMessage(user,pageBean,messageid);//调用业务层

        session.setAttribute("messageSet",result.getMessages());
        session.setAttribute("pageBean",result.getPageBean());
        return "message";
    }

    @RequestMapping("IntoEditMessageController")
    public String IntoEditMessageController(HttpServletRequest req) throws UnsupportedEncodingException {
        req.setCharacterEncoding("UTF-8");
        String messageid = req.getParameter("messageid");
        req.setAttribute("messageid",messageid);

        Result result = messageService.intoEditMessage(messageid);//调用业务层

        Message message = result.getMessages().get(0);
        req.setAttribute("message",message);
        return "edit";
    }

    @RequestMapping("EditMessageSuccessController")
    public String editsuccesscontroller(HttpServletRequest req) throws UnsupportedEncodingException {
        req.setCharacterEncoding("UTF-8");
        HttpSession session = req.getSession();
        String messageid = req.getParameter("messageid");
        String label = req.getParameter("label");
        String detail = req.getParameter("detail");

        Result result = messageService.commitEditMessage(messageid, label, detail);//调用业务层

        session.setAttribute("messageSet",result.getMessages());
        return "message";
    }
}
