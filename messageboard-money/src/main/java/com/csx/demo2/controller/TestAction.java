package com.csx.demo2.controller;

import com.csx.demo2.dao.MessageDao;
import com.csx.demo2.dao.UserDao;
import com.csx.demo2.entity.*;
import com.csx.demo2.service.LogService;
import com.csx.demo2.service.MessageService;
import com.csx.demo2.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
public class TestAction {

    @Autowired
    private UserService userService;

    @Autowired
    private MessageService messageService;

    @Autowired
    private MessageDao messageDao;

    @Autowired
    private UserDao userDao;

    @Autowired
    private LogService logService;


    /**
     * 查询留言  包含条件查询和查询所有
     *
     * @param req
     * @param resp
     * @return
     * @throws IOException
     */
    @ResponseBody
    @RequestMapping("/easyui_queryMessages")
    public Page easyui_queryMessages(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String page = req.getParameter("page");
        String rows = req.getParameter("rows");
        String messageid = req.getParameter("id");
        String userid = req.getParameter("user_id");
        System.out.println("///");

        Page pagebean = null;
        if (!StringUtils.isNoBlank(messageid) && !StringUtils.isNoBlank(userid)) {
            pagebean = messageService.findpage(Integer.valueOf(page), Integer.valueOf(rows), null, null);
        } else if (!StringUtils.isNoBlank(messageid) && StringUtils.isNoBlank(userid)) {
            pagebean = messageService.findpage(Integer.valueOf(page), Integer.valueOf(rows), null, Integer.valueOf(userid));
        } else if (StringUtils.isNoBlank(messageid) && !StringUtils.isNoBlank(userid)) {
            pagebean = messageService.findpage(Integer.valueOf(page), Integer.valueOf(rows), Integer.valueOf(messageid), null);
        } else {
            pagebean = messageService.findpage(Integer.valueOf(page), Integer.valueOf(rows), Integer.valueOf(messageid), Integer.valueOf(userid));
        }

        return pagebean;
    }


    /**
     * 创建新的留言
     *
     * @param req
     * @param label  留言的标题
     * @param detail 留言的内容
     * @return
     */
    @ResponseBody
    @RequestMapping("/easyui_createMessage")
    public String easyui_createMessage(HttpServletRequest req, @RequestParam String label, @RequestParam String detail) {

        System.out.println(label + detail);
        HttpSession session = req.getSession();
        User user = (User) session.getAttribute("user");

        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date_create = simpleDateFormat.format(date);
        String date_edit = date_create;
        messageDao.insert(new Message.Builder().label(label).detail(detail).date_edit(date_edit).date_create(date_create).user_id(user.getId()).build());

        return "success";
    }

    /**
     * 编辑留言
     *
     * @param label     修改后的标题
     * @param detail    修改后的内容
     * @param messageid 需要修改的留言id
     * @param user_id
     * @return
     */
    @ResponseBody
    @RequestMapping("/easyui_editMessage")
    public String easyui_editMessage(@RequestParam String label, @RequestParam String detail, @RequestParam String messageid, @RequestParam String user_id) {
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date_edit = simpleDateFormat.format(date);
        messageDao.update(new Message.Builder().id(Integer.valueOf(messageid)).label(label).detail(detail).date_edit(date_edit).user_id(Integer.valueOf(user_id)).build());
        return "success";
    }

    /**
     * 删除留言
     *
     * @param messageid
     * @return
     */
    @ResponseBody
    @RequestMapping("/easyui_removeMessage")
    public String easyui_removeMessage(@RequestParam String messageid) {

        System.out.println(messageid);
        messageDao.deleteById(Integer.valueOf(messageid));
        return "success";
    }

    /**
     * 查询用户信息  包含条件查询和查询全部
     *
     * @param req
     * @param resp
     * @return
     * @throws IOException
     */
    @ResponseBody
    @RequestMapping("/easyui_queryUsers")
    public Page testqueryAllUser(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String page = req.getParameter("page");
        String rows = req.getParameter("rows");
        String userid = req.getParameter("userid");
        String groupid = req.getParameter("groupid");

        Page pagebean = null;
        if (!StringUtils.isNoBlank(userid) && !StringUtils.isNoBlank(groupid)) {
            pagebean = userService.findpage(Integer.valueOf(page), Integer.valueOf(rows), null, null);
        } else if (!StringUtils.isNoBlank(userid) && StringUtils.isNoBlank(groupid)) {
            pagebean = userService.findpage(Integer.valueOf(page), Integer.valueOf(rows), null, Integer.valueOf(groupid));
        } else if (StringUtils.isNoBlank(userid) && !StringUtils.isNoBlank(groupid)) {
            pagebean = userService.findpage(Integer.valueOf(page), Integer.valueOf(rows), Integer.valueOf(userid), null);
        } else {
            pagebean = userService.findpage(Integer.valueOf(page), Integer.valueOf(rows), Integer.valueOf(userid), Integer.valueOf(groupid));
        }
        return pagebean;
    }

    /**
     * 编辑用户信息
     *
     * @param name
     * @param email
     * @param phone
     * @param userid
     * @return
     */
    @ResponseBody
    @RequestMapping("/easyui_editUser")
    public String easyui_editUser(@RequestParam String name, @RequestParam String email, @RequestParam String phone, @RequestParam String userid) {
        userDao.update(new User.Builder().id(Integer.valueOf(userid)).name(name).email(email).phone(phone).build());
        return "success";
    }

    /**
     * 查询日志
     *
     * @param req
     * @param resp
     * @return
     * @throws IOException
     */
    @ResponseBody
    @RequestMapping("/easyui_queryLogs")
    public Page easyui_queryLogs(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String page = req.getParameter("page");
        String rows = req.getParameter("rows");
        String username = req.getParameter("username");
        Page pagebean = null;
        if (StringUtils.isNoBlank(username)) {
            List<Log> logs = logService.selectAll();
        } else {
            List<Log> logs = logService.selectAll();
        }

        return pagebean;
    }


    @ResponseBody
    @RequestMapping("/easyui_emptyLogs")
    public void easyui_emptyLogs(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        logService.deleteAllLog();
        return;
    }


}
