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

    @RequestMapping("SelectMessageByUserNameController")//
    public String Selectbynamecontroller(HttpServletRequest req) throws UnsupportedEncodingException {
        req.setCharacterEncoding("UTF-8");
        String name = req.getParameter("name");
        HttpSession session = req.getSession();

        Result result = messageService.selectMessageByUserName(name);//调用业务层

        session.setAttribute("messageSet",result.getMessages());
        session.setAttribute("pageBean",result.getPageBean());
        return "redirect:"+"message";
    }

    /*
    * 查看个人留言
    * */
    @RequestMapping("SelectPersonMessageController")//
    public String SelectPersonMessageController(HttpServletRequest req) throws UnsupportedEncodingException {
        req.setCharacterEncoding("UTF-8");
        HttpSession session = req.getSession();
        User user = (User)session.getAttribute("user");

        Result result = messageService.selectPersonMessage(user);//调用业务层

        session.setAttribute("logmsg",result.getMessages().toString());
        session.setAttribute("messageSet",result.getMessages());//把个人的留言添加到session域中
        session.setAttribute("pageBean",result.getPageBean());
        return "redirect:"+"message";
    }

    /*
    * 查看所在组的留言
    * */
    @RequestMapping("SelectGroupMessageController")//
    public String SelectGroupMessageController(HttpServletRequest req) throws UnsupportedEncodingException {
        req.setCharacterEncoding("UTF-8");
        HttpSession session = req.getSession();
        User user = (User)session.getAttribute("user");

        Result result = messageService.selectGroupMessage(user);//调用业务层

        session.setAttribute("logmsg",result.getMessages().toString());
        session.setAttribute("messageSet",result.getMessages());
        session.setAttribute("pageBean",result.getPageBean());
        return "redirect:"+"message";
    }

    /*
    * 查询其他组的留言
    * */
    @RequestMapping("SelectOtherGroupMessageController")//
    public String SelectOtherGroupMessageController(HttpServletRequest req) throws UnsupportedEncodingException {
        req.setCharacterEncoding("UTF-8");
        HttpSession session = req.getSession();
        User user = (User)session.getAttribute("user");

        Result result = messageService.selectOtherGroupMessage(user);//调用业务层

        session.setAttribute("logmsg",result.getMessages().toString());
        session.setAttribute("messageSet",result.getMessages());
        session.setAttribute("pageBean",result.getPageBean());
        return "redirect:"+"message";
    }

    /**
     * 查询所有人的留言
     */
    @RequestMapping("SelectAllMessageController")//
    public String SelectAllMessageController(HttpServletRequest req) throws UnsupportedEncodingException {
        req.setCharacterEncoding("UTF-8");
        HttpSession session = req.getSession();

        Result result = messageService.selectAllMessage();//调用业务层

        session.setAttribute("messageSet",result.getMessages());
        session.setAttribute("pageBean",result.getPageBean());
        return "redirect:"+"message";
    }

    /**
     * 新建留言
     * @param req
     * @return
     * @throws UnsupportedEncodingException
     */
    @RequestMapping("CreateMessageController")//
    public String CreateMessageController(HttpServletRequest req) throws UnsupportedEncodingException {
        req.setCharacterEncoding("UTF-8");
        HttpSession session = req.getSession();
        User user = (User)session.getAttribute("user");
        String label = req.getParameter("label");
        String detail = req.getParameter("detail");
        PageBean pageBean = (PageBean)session.getAttribute("pageBean");

        Result result = messageService.createMessage(pageBean, user, label, detail);//调用业务层

        session.setAttribute("logmsg","新建留言"+result.getLogmsg()+"成功");
        session.setAttribute("pageBean",result.getPageBean());
        session.setAttribute("messageSet",result.getMessages());
        return "redirect:"+"message";
    }

    /**
     * 删除留言
     * @param req
     * @return
     * @throws UnsupportedEncodingException
     */
    @RequestMapping("DeleteMessageController")//
    public String DeleteMessageController(HttpServletRequest req) throws UnsupportedEncodingException {
        req.setCharacterEncoding("UTF-8");
        String messageid = req.getParameter("messageid");//获取要删除的留言id
        HttpSession session = req.getSession();
        PageBean pageBean = (PageBean)session.getAttribute("pageBean");
        User user = (User)session.getAttribute("user");

        Result result = messageService.deleteMessage(user,pageBean,messageid);//调用业务层

        session.setAttribute("logmsg",result.getLogmsg());
        session.setAttribute("messageSet",result.getMessages());
        session.setAttribute("pageBean",result.getPageBean());
        return "redirect:"+"message";
    }

    /**
     * 进入留言编辑页面
     * @param req
     * @return
     * @throws UnsupportedEncodingException
     */
    @RequestMapping("IntoEditMessageController")//
    public String IntoEditMessageController(HttpServletRequest req) throws UnsupportedEncodingException {
        req.setCharacterEncoding("UTF-8");
        String messageid = req.getParameter("messageid");
        //System.out.println("准备修改的message的id:"+messageid);
        req.setAttribute("messageid",messageid);

        Result result = messageService.intoEditMessage(messageid);//调用业务层

        Message message = result.getMessages().get(0);
        req.getSession().setAttribute("message",message);
        return "redirect:"+"edit";
    }

    /**
     * 完成编辑留言的功能
     * @param req
     * @return
     * @throws UnsupportedEncodingException
     */

    @RequestMapping("EditMessageSuccessController")//
    public String EditMessageSuccessController(HttpServletRequest req) throws UnsupportedEncodingException {
        req.setCharacterEncoding("UTF-8");
        HttpSession session = req.getSession();
        User user = (User)session.getAttribute("user");
        PageBean pageBean = (PageBean)session.getAttribute("pageBean");
        String messageid = req.getParameter("messageid");
        String label = req.getParameter("label");
        String detail = req.getParameter("detail");

        Result result = messageService.commitEditMessage(messageid, label, detail,pageBean,user);//调用业务层

        session.setAttribute("logmsg",result.getLogmsg());
        session.setAttribute("pageBean",result.getPageBean());
        session.setAttribute("messageSet",result.getMessages());
        return "redirect:"+"message";
    }
}
