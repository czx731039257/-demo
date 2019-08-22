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

    @RequestMapping(value="/login")
    public String login(){
        return "login";
    }
    @RequestMapping(value="/message")
    public String message(){
        return "message";
    }
    @RequestMapping(value="/create")
    public String create(){
        return "create";
    }
    @RequestMapping(value="/edit")
    public String edit(){
        return "edit";
    }

    @RequestMapping(value="/users")
    public String users(){
        return "users";
    }
    @RequestMapping(value="/person")
    public String usermessage(){
        return "person";
    }
    @RequestMapping(value="/editperson")
    public String editusermessage(){
        return "editperson";
    }
    @RequestMapping(value="/edituser")
    public String edituser(){
        return "edituser";
    }

    @RequestMapping(value="/roles")//
    public String roles(){
        return "roles";
    }
    @RequestMapping(value="/editrole")//
    public String editrole(){
        return "editrole";
    }

    @RequestMapping(value="/permission")//
    public String permission(){
        return "permission";
    }

    @RequestMapping(value="/allocation")//
    public String allocation(){
        return "allocation";
    }

    @RequestMapping(value="/log")
    public String log(){
        return "log";
    }

    @RequestMapping(value="/headlist")
    public String headlist(){
        return "headlist";
    }



    @RequestMapping(value="/recharge")
    public String recharge(){
        return "recharge";
    }

    @RequestMapping(value="/reward")
    public String reward(HttpServletRequest req){
        String messagehostid = req.getParameter("messagehostid");
        req.getSession().setAttribute("messagehostid",messagehostid);
        return "reward";
    }

    @RequestMapping(value="/bill")
    public String bill(HttpServletRequest req){
        return "bill";
    }

    @RequestMapping(value="/testui")
    public String testui(HttpServletRequest req){
        return "testui";
    }
}
