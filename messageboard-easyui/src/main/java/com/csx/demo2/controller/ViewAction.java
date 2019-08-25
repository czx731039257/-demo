package com.csx.demo2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/*
* 中转类
* 访问jsp文件
* */

@Controller
public class ViewAction {



    @RequestMapping(value="/messages")
    public String messages(HttpServletRequest req){
        return "messages";
    }

    @RequestMapping(value="/users")
    public String users(HttpServletRequest req){
        return "users";
    }

    @RequestMapping(value="/logs")
    public String logs(HttpServletRequest req){
        return "logs";
    }

    @RequestMapping(value="/bills")
    public String bills(HttpServletRequest req){
        return "bills";
    }

    @RequestMapping(value="/login")
    public String login(HttpServletRequest req){
        return "login";
    }
}
