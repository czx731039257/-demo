package com.demo.sis.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/*
 * 中转类
 * 访问jsp文件
 * */

@Controller
public class ViewAction {

    @RequestMapping("/students")
    public String student() {
        return "students";
    }

    @RequestMapping("/teachers")
    public String teachers() {
        return "teachers";
    }

    @RequestMapping("/courses")
    public String courses() {
        return "courses";
    }

    @RequestMapping("/classes")
    public String classes() {
        return "classes";
    }

    @RequestMapping("/homepage")
    public String homepage() {
        return "homepage";
    }

    @RequestMapping("/login")
    public String login() {
        return "login";
    }

}
