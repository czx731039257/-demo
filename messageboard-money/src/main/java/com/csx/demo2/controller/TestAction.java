package com.csx.demo2.controller;

import com.csx.demo2.dao.MessageDao;
import com.csx.demo2.entity.*;
import com.csx.demo2.service.MessageService;
import com.csx.demo2.service.UserService;
import net.minidev.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Controller
public class TestAction {

    @Autowired
    private UserService userService;

    @Autowired
    private MessageService messageService;

    @Autowired
    private MessageDao messageDao;

    @ResponseBody
    @RequestMapping("/testqueryAllMessage")
    public Page testqueryAllMessage(HttpServletRequest req,HttpServletResponse resp) throws IOException {
        String page = req.getParameter("page");
        String rows = req.getParameter("rows");
        String messageid = req.getParameter("id");
        String userid = req.getParameter("user_id");

        Page pagebean=null;
        if(!StringUtils.isNoBlank(messageid)&&!StringUtils.isNoBlank(userid)) {
            pagebean = messageService.findpage(Integer.valueOf(page), Integer.valueOf(rows), null, null);
        }else if(!StringUtils.isNoBlank(messageid)&&StringUtils.isNoBlank(userid)){
            pagebean = messageService.findpage(Integer.valueOf(page), Integer.valueOf(rows), null, Integer.valueOf(userid));
        } else if(StringUtils.isNoBlank(messageid)&&!StringUtils.isNoBlank(userid)){
            pagebean = messageService.findpage(Integer.valueOf(page), Integer.valueOf(rows), Integer.valueOf(messageid), null);
        }else{
            pagebean = messageService.findpage(Integer.valueOf(page), Integer.valueOf(rows), Integer.valueOf(messageid), Integer.valueOf(userid));
        }
        return pagebean;
    }


    @ResponseBody
    @RequestMapping("/testnewMessage")
    public Test testnewMessage(HttpServletRequest req,@RequestParam String label,@RequestParam String detail){
        HttpSession session = req.getSession();
        User user = (User)session.getAttribute("user");

        Date date =new Date();
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date_create =simpleDateFormat.format(date);
        String date_edit=date_create;
        messageDao.insert(new Message(null,label,detail,date_create,date_edit,user.getId()));
        return new Test();
    }

    @ResponseBody
    @RequestMapping("/testeditMessage")
    public Test testeditMessage(@RequestParam String label,@RequestParam String detail,@RequestParam String messageid,@RequestParam String user_id){
        Date date =new Date();
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date_edit =simpleDateFormat.format(date);
        messageDao.update(new Message(Integer.valueOf(messageid),label,detail,null,date_edit,Integer.valueOf(user_id)));
        return new Test();
    }

    @ResponseBody
    @RequestMapping("/testdeleteMessage")
    public Test testdeleteMessage(@RequestParam String messageid){
        messageDao.deleteById(Integer.valueOf(messageid));
        return new Test(null,"删除成功");
    }

    @ResponseBody
    @RequestMapping("/testqueryAllUser")
    public Test testqueryAllUser(HttpServletRequest req,HttpServletResponse resp){
        String page = req.getParameter("page");
        String rows = req.getParameter("rows");
        String userid = req.getParameter("userid");
        String groupid = req.getParameter("groupid");
        Page pagebean=null;
        if(!StringUtils.isNoBlank(userid)&&!StringUtils.isNoBlank(groupid)) {
            pagebean = messageService.findpage(Integer.valueOf(page), Integer.valueOf(rows), null, null);
        }else if(!StringUtils.isNoBlank(userid)&&StringUtils.isNoBlank(groupid)){
            pagebean = messageService.findpage(Integer.valueOf(page), Integer.valueOf(rows), null, Integer.valueOf(userid));
        } else if(StringUtils.isNoBlank(userid)&&!StringUtils.isNoBlank(groupid)){
            pagebean = messageService.findpage(Integer.valueOf(page), Integer.valueOf(rows), Integer.valueOf(messageid), null);
        }else{
            pagebean = messageService.findpage(Integer.valueOf(page), Integer.valueOf(rows), Integer.valueOf(messageid), Integer.valueOf(userid));
        }
        return pagebean;
    }

}
