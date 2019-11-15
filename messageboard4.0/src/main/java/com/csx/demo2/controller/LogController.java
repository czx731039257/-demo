package com.csx.demo2.controller;

import com.csx.demo2.entity.Log;
import com.csx.demo2.entity.PageBean;
import com.csx.demo2.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class LogController {

    @Autowired
    private LogService logService;

    @RequestMapping("selectlog")
    public String selectlog(HttpServletRequest req) {
        List<Log> logs = logService.selectAll();
        PageBean pageBeanForLog = new PageBean(1, logs.size());
        HttpSession session = req.getSession();
        session.setAttribute("logs", logs);
        session.setAttribute("pageBeanForLog", pageBeanForLog);
        return "redirect:" + "log";
    }

    @RequestMapping("selectlogByUserName")
    public String selectlogByUserName(HttpServletRequest req) {
        HttpSession session = req.getSession();
        String username = req.getParameter("username");
        if (username.equals("")) {
            session.setAttribute("finderror", "empty");
            return "redirect:" + "log";
        }
        List<Log> logs = logService.selectByUserName(username);
        PageBean pageBeanForLog = new PageBean(1, logs.size());
        session.setAttribute("logs", logs);
        session.setAttribute("pageBeanForLog", pageBeanForLog);
        return "redirect:" + "log";
    }


    @RequestMapping("deleteAllLog")
    public String deleteAllLog(HttpServletRequest req) {
        logService.deleteAllLog();
        List<Log> logs = logService.selectAll();
        PageBean pageBeanForLog = new PageBean(1, logs.size());
        HttpSession session = req.getSession();
        session.setAttribute("logs", logs);
        session.setAttribute("pageBeanForLog", pageBeanForLog);
        return "redirect:" + "log";
    }

}
