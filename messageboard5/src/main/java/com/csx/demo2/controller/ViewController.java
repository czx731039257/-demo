package com.csx.demo2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/*
 * 中转类
 * 访问jsp文件
 * */

@Controller
public class ViewController {

    @RequestMapping(value = "/login")
    public String login() {
        //System.out.println("用户访问login.jsp页面");
        return "login";
    }

    @RequestMapping(value = "/message")
    public String message() {
        //System.out.println("用户访问message.jsp页面");
        return "message";
    }

    @RequestMapping(value = "/create")
    public String create() {
        //System.out.println("用户访问create.jsp页面");
        return "create";
    }

    @RequestMapping(value = "/edit")
    public String edit() {
        //System.out.println("用户访问edit.jsp页面");
        return "edit";
    }

    @RequestMapping(value = "/users")
    public String users() {
        //System.out.println("用户访问users.jsp页面");
        return "users";
    }

    @RequestMapping(value = "/person")
    public String usermessage() {
        //System.out.println("用户访问person.jsp页面");
        return "person";
    }

    @RequestMapping(value = "/editperson")
    public String editusermessage() {
        // System.out.println("用户访问editperson.jsp页面");
        return "editperson";
    }

    @RequestMapping(value = "/edituser")
    public String edituser() {
        //System.out.println("用户访问edituser.jsp页面");
        return "edituser";
    }

    @RequestMapping(value = "/roles")//
    public String roles() {
        //System.out.println("用户访问roles.jsp页面");
        return "roles";
    }

    @RequestMapping(value = "/editrole")//
    public String editrole() {
        //System.out.println("用户访问roles.jsp页面");
        return "editrole";
    }

    @RequestMapping(value = "/permission")//
    public String permission() {
        //System.out.println("用户访问permission.jsp页面");
        return "permission";
    }

    @RequestMapping(value = "/allocation")//
    public String allocation() {
        //System.out.println("用户访问allocation.jsp页面");
        return "allocation";
    }

    @RequestMapping(value = "/test1")
    public String test1() {
        //System.out.println("用户访问test1.jsp页面");
        return "test1";
    }

    @RequestMapping(value = "/log")
    public String log() {
        //System.out.println("用户访问test1.jsp页面");
        return "log";
    }

    @RequestMapping(value = "/testupload")
    public String testupload() {
        //System.out.println("用户访问test1.jsp页面");
        return "testupload";
    }

    @RequestMapping(value = "/filelist")
    public String filelist() {
        //System.out.println("用户访问test1.jsp页面");
        return "headlist";
    }

    @RequestMapping(value = "/headlist")
    public String headlist() {
        //System.out.println("用户访问test1.jsp页面");
        return "headlist";
    }
}
