package com.csx.demo2.controller;

import com.csx.demo2.dao.MessageDao;
import com.csx.demo2.entity.*;
import com.csx.demo2.service.MessageService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
@RequestMapping("/message")
public class MessageAction {

    @Autowired
    private MessageService messageService;

    @Autowired
    private MessageDao messageDao;
    /**
     * 查询留言  包含条件查询和查询所有
     * @param req
     * @return
     * @throws IOException
     */
    @ResponseBody
    @RequestMapping("/queryAllMessages")
    public Page queryMessages(HttpServletRequest req) throws IOException {
        Integer pageNumber = Integer.valueOf(req.getParameter("page"));
        Integer pageSize = Integer.valueOf(req.getParameter("rows"));
        String messageid = req.getParameter("messageid");
        String username = req.getParameter("username");
        String groupid=req.getParameter("groupid");
        Page page=new Page.Builder().pageNumber(pageNumber).pageSize(pageSize).startIndex((pageNumber-1)*pageSize).build();

        User user=new User();
        Message message=new Message();
        if(StringUtils.isNoBlank(messageid)){
            message.setId(Integer.valueOf(messageid));
            page.setMessage(message);
        }
        if(StringUtils.isNoBlank(username)){
            user.setName(username);
            message.setUser(user);
            page.setMessage(message);
        }
        if(StringUtils.isNoBlank(groupid)){
            user.setGroup_id(Integer.valueOf(groupid));
            message.setUser(user);
            page.setMessage(message);
        }
        page = messageService.findpage(page);
        return page;
    }


    /**
     * 创建新的留言
     * @param req
     * @return
     */
    @ResponseBody
    @RequestMapping("/createMessage")
    public Result createMessage(HttpServletRequest req){
        String label = req.getParameter("label");
        String detail = req.getParameter("detail");
        Date date =new Date();
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date_create =simpleDateFormat.format(date);
        String date_edit=date_create;
        boolean i=messageService.insert(new Message.Builder().label(label).detail(detail).date_edit(date_edit).date_create(date_create).build());
        if(i) {
            return new Result.Builder().successMsg("新建留言成功").build();
        }else{
            return new Result.Builder().errorMsg("新建留言失败").build();
        }
    }

    /**
     * 编辑留言
     * @param label 修改后的标题
     * @param detail 修改后的内容
     * @param messageid 需要修改的留言id
     * @param user_id
     * @return
     */
    @ResponseBody
    @RequestMapping("/editMessage")
    public Result editMessage(@RequestParam String label,@RequestParam String detail,@RequestParam String messageid,@RequestParam String user_id){
        Date date =new Date();
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date_edit =simpleDateFormat.format(date);
        boolean i = messageService.update(new Message.Builder().id(Integer.valueOf(messageid)).label(label).detail(detail).date_edit(date_edit).user_id(Integer.valueOf(user_id)).build());
        if(i){
            return new Result.Builder().successMsg("编辑留言成功").build();
        }else{
            return new Result.Builder().errorMsg("编辑留言失败").build();
        }
    }

    /**
     * 删除留言
     * @param messageid
     * @return
     */
    @ResponseBody
    @RequestMapping("/removeMessage")
    public Result removeMessage(@RequestParam String messageid){
        boolean i = messageService.deleteById(Integer.valueOf(messageid));
        if(i){
            return new Result.Builder().successMsg("删除留言成功").build();
        }else{
            return new Result.Builder().errorMsg("删除留言失败").build();
        }
    }


    @ResponseBody
    @RequestMapping("/asd")
    public Page asd(){
        System.out.println("sdasd");
        return new Page.Builder().rows(null).total(0).build();
    }

    @ResponseBody
    @RequestMapping("queryGroupMessages")
    public Page queryGroupMessage(HttpServletRequest req){
        HttpSession session = req.getSession();
        User nowuser = (User)session.getAttribute("user");
        Integer pageNumber = Integer.valueOf(req.getParameter("page"));
        Integer pageSize = Integer.valueOf(req.getParameter("rows"));
        String messageid = req.getParameter("messageid");
        String username = req.getParameter("username");
        Page page=new Page.Builder().pageNumber(pageNumber).pageSize(pageSize).startIndex((pageNumber-1)*pageSize).build();

        User user=new User();
        Message message=new Message();
        if(StringUtils.isNoBlank(messageid)){
            message.setId(Integer.valueOf(messageid));
            page.setMessage(message);
        }
        if(StringUtils.isNoBlank(username)){
            user.setName(username);
            message.setUser(user);
            page.setMessage(message);
        }
        user.setGroup_id(nowuser.getGroup_id());
        message.setUser(user);
        page.setMessage(message);
        page = messageService.findpage(page);
        return page;
    }

    @ResponseBody
    @RequestMapping("queryPersonMessages")
    public Page queryPersonMessages(HttpServletRequest req){
        HttpSession session = req.getSession();
        User nowuser = (User)session.getAttribute("user");
        Integer pageNumber = Integer.valueOf(req.getParameter("page"));
        Integer pageSize = Integer.valueOf(req.getParameter("rows"));
        String messageid = req.getParameter("messageid");

        Page page=new Page.Builder().pageNumber(pageNumber).pageSize(pageSize).startIndex((pageNumber-1)*pageSize).build();

        User user=new User();
        Message message=new Message();
        if(StringUtils.isNoBlank(messageid)){
            message.setId(Integer.valueOf(messageid));
            page.setMessage(message);
        }
        user.setName(nowuser.getName());
        message.setUser(user);
        page.setMessage(message);
        page = messageService.findpage(page);
        return page;
    }
}
