package com.csx.demo2.controller;

import com.csx.demo2.entity.Log;
import com.csx.demo2.entity.PageBean;
import com.csx.demo2.service.LogService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class LogAction {

    @Autowired
    private LogService logService;

    /**
     * 查看所有人的日志
     * @param req
     * @return
     */
    @RequiresPermissions("查看日志")
    @RequestMapping("queryAllLog")
    public String queryAllLog(HttpServletRequest req){
        List<Log> logs = logService.selectAll();
        PageBean pageBeanForLog=new PageBean(1,logs.size());
        HttpSession session = req.getSession();
        session.setAttribute("logs",logs);
        session.setAttribute("pageBeanForLog",pageBeanForLog);
        return "redirect:"+"log";
    }

    /**
     * 根据用户名搜索该用户的所有日志
     * @param req
     * @return
     */
    @RequiresPermissions("查看日志")
    @RequestMapping("queryLogByUserName")
    public String queryLogByUserName(HttpServletRequest req){
        HttpSession session = req.getSession();
        String username = req.getParameter("username");
        if(username.equals("")){
            session.setAttribute("finderror","empty");
            return "redirect:"+"log";
        }
        List<Log> logs = logService.selectByUserName(username);
        PageBean pageBeanForLog=new PageBean(1,logs.size());
        session.setAttribute("logs",logs);
        session.setAttribute("pageBeanForLog",pageBeanForLog);
        return "redirect:"+"log";
    }


    /**
     * 清空所有日志
     * @param req
     * @return
     */
    @RequiresPermissions("查看日志")
    @RequestMapping("emptyAllLog")
    public String emptyAllLog(HttpServletRequest req){
        logService.deleteAllLog();
        List<Log> logs = logService.selectAll();
        PageBean pageBeanForLog=new PageBean(1,logs.size());
        HttpSession session = req.getSession();
        session.setAttribute("logs",logs);
        session.setAttribute("pageBeanForLog",pageBeanForLog);
        return "redirect:"+"log";
    }

}
