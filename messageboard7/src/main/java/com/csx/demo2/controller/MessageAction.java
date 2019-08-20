package com.csx.demo2.controller;

import com.csx.demo2.dao.UserDao;
import com.csx.demo2.entity.Message;
import com.csx.demo2.entity.PageBean;
import com.csx.demo2.entity.Result;
import com.csx.demo2.entity.User;
import com.csx.demo2.service.MessageService;
import com.csx.demo2.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.AuthorizationException;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.UnsupportedEncodingException;


@Controller
public class MessageAction {

    @Autowired
    private MessageService messageService;


    /**
     * 根据用户名查看该用户的所有留言
     * @param req
     * @return
     * @throws UnsupportedEncodingException
     */
    @RequestMapping("queryMessageByUsername")//
    public String queryMessageByUsername(HttpServletRequest req) throws UnsupportedEncodingException {
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
    @RequiresPermissions({"浏览自己的留言"})
    @RequestMapping("queryPersonMessage")//
    public String queryPersonMessage(HttpServletRequest req) throws UnsupportedEncodingException {
        req.setCharacterEncoding("UTF-8");
        HttpSession session = req.getSession();
        User user = (User)session.getAttribute("user");

        Result result = messageService.selectPersonMessage(user);//调用业务层

        session.setAttribute("logmsg","成功");
        session.setAttribute("messageSet",result.getMessages());//把个人的留言添加到session域中
        session.setAttribute("pageBean",result.getPageBean());
        return "redirect:"+"message";
    }


    /*
    * 查看所在组的留言
    * */
    @RequiresPermissions({"浏览所在组的人的留言"})
    @RequestMapping("querySameGroupMessage")//
    public String querySameGroupMessage(HttpServletRequest req) throws UnsupportedEncodingException {
        req.setCharacterEncoding("UTF-8");
        HttpSession session = req.getSession();
        User user = (User)session.getAttribute("user");

        Result result = messageService.selectGroupMessage(user);//调用业务层

        session.setAttribute("logmsg","成功");
        session.setAttribute("messageSet",result.getMessages());
        session.setAttribute("pageBean",result.getPageBean());
        return "redirect:"+"message";
    }

    /*
    * 查询其他组的留言
    * */
    @RequiresPermissions({"浏览其他组的人的留言"})
    @RequestMapping("queryOtherGroupMessage")//
    public String queryOtherGroupMessage(HttpServletRequest req) throws UnsupportedEncodingException {
        req.setCharacterEncoding("UTF-8");
        HttpSession session = req.getSession();
        User user = (User)session.getAttribute("user");

        Result result = messageService.selectOtherGroupMessage(user);//调用业务层

        session.setAttribute("logmsg","成功");
        session.setAttribute("messageSet",result.getMessages());
        session.setAttribute("pageBean",result.getPageBean());
        return "redirect:"+"message";
    }

    /**
     * 查询所有人的留言
     */
    @RequiresPermissions({"浏览自己的留言","浏览所在组的人的留言","浏览其他组的人的留言"})
    @RequestMapping("queryAllMessage")//
    public String queryAllMessage(HttpServletRequest req) throws UnsupportedEncodingException {
        req.setCharacterEncoding("UTF-8");
        HttpSession session = req.getSession();

        Result result = messageService.selectAllMessage();//调用业务层

        session.setAttribute("logmsg","成功");
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
    @RequiresPermissions({"新建留言"})
    @RequestMapping("createMessage")//
    public String createMessage(HttpServletRequest req) throws UnsupportedEncodingException {
        req.setCharacterEncoding("UTF-8");
        HttpSession session = req.getSession();
        User user = (User)session.getAttribute("user");
        String label = req.getParameter("label");
        String detail = req.getParameter("detail");
        PageBean pageBean = (PageBean)session.getAttribute("pageBean");

        Result result = messageService.createMessage(pageBean, user, label, detail);//调用业务层

        session.setAttribute("logmsg","成功");
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
    @RequestMapping("deleteMessage")//
    public String deleteMessage(HttpServletRequest req) throws UnsupportedEncodingException {
        req.setCharacterEncoding("UTF-8");
        String messageid = req.getParameter("messageid");//获取要删除的留言id
        HttpSession session = req.getSession();
        PageBean pageBean = (PageBean)session.getAttribute("pageBean");
        User user = (User)session.getAttribute("user");
        User userByMessage = messageService.selectUserByMessageId(Integer.valueOf(messageid));
        Subject subject = SecurityUtils.getSubject();
        if(user.getId()==userByMessage.getId()){
            if(!subject.isPermitted("删除自己的留言")){
                throw new AuthorizationException();
            }
        }else{
            if(user.getGroup_id()==userByMessage.getGroup_id()){
                if(!subject.isPermitted("删除所在用户组的人的留言")){
                    throw new AuthorizationException();
                }
            }else{
                if(!subject.isPermitted("删除其他用户组的人的留言")){
                    throw new AuthorizationException();
                }
            }
        }

        Result result = messageService.deleteMessage(user,pageBean,messageid);//调用业务层

        session.setAttribute("logmsg","成功");
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
    @RequestMapping("intoEditMessage")//
    public String intoEditMessage(HttpServletRequest req) throws UnsupportedEncodingException {
        req.setCharacterEncoding("UTF-8");
        String messageid = req.getParameter("messageid");
        HttpSession session = req.getSession();
        User user = (User)session.getAttribute("user");


        User userByMessage = messageService.selectUserByMessageId(Integer.valueOf(messageid));
        Subject subject = SecurityUtils.getSubject();
        if(user.getId()==userByMessage.getId()){
            if(!subject.isPermitted("编辑自己的留言")){
                throw new AuthorizationException();
            }
        }else{
            if(user.getGroup_id()==userByMessage.getGroup_id()){
                if(!subject.isPermitted("编辑所在用户组的人的留言")){
                    throw new AuthorizationException();
                }
            }else{
                if(!subject.isPermitted("编辑其他用户组的人的留言")){
                    throw new AuthorizationException();
                }
            }
        }


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

    @RequestMapping("editMessageSuccess")//
    public String editMessageSuccess(HttpServletRequest req) throws UnsupportedEncodingException {
        req.setCharacterEncoding("UTF-8");
        HttpSession session = req.getSession();
        User user = (User)session.getAttribute("user");
        String messageid = req.getParameter("messageid");
        User userByMessage = messageService.selectUserByMessageId(Integer.valueOf(messageid));
        Subject subject = SecurityUtils.getSubject();
        if(user.getId()==userByMessage.getId()){
            if(!subject.isPermitted("编辑自己的留言")){
                throw new AuthorizationException();
            }
        }else{
            if(user.getGroup_id()==userByMessage.getGroup_id()){
                if(!subject.isPermitted("编辑所在用户组的人的留言")){
                    throw new AuthorizationException();
                }
            }else{
                if(!subject.isPermitted("编辑其他用户组的人的留言")){
                    throw new AuthorizationException();
                }
            }
        }


        PageBean pageBean = (PageBean)session.getAttribute("pageBean");

        String label = req.getParameter("label");
        String detail = req.getParameter("detail");

        Result result = messageService.commitEditMessage(messageid, label, detail,pageBean,user);//调用业务层

        session.setAttribute("logmsg","成功");
        session.setAttribute("pageBean",result.getPageBean());
        session.setAttribute("messageSet",result.getMessages());
        return "redirect:"+"message";
    }
}
