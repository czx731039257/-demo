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

    @RequestMapping(value="/groupmessages")
    public String groupmessages(HttpServletRequest req){
        return "groupmessages";
    }

    @RequestMapping(value="/allmessages")
    public String allmessages(HttpServletRequest req){
        return "allmessages";
    }

    @RequestMapping(value="/personmessages")
    public String personmessages(HttpServletRequest req){
        return "personmessages";
    }

    @RequestMapping(value="/personInfo")
    public String personInfo(HttpServletRequest req){
        return "personInfo";
    }

    @RequestMapping(value="/allInfo")
    public String allInfo(HttpServletRequest req){
        return "allInfo";
    }

    @RequestMapping(value="/test")
    public String test(HttpServletRequest req){
        return "test";
    }
}
