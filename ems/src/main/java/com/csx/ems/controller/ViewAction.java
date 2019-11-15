package com.csx.ems.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ViewAction {

    @RequestMapping("/test")
    public String test(){
        return "test";
    }

    @RequestMapping("/test1")
    public String test1(){
        return "test1";
    }

    @RequestMapping("/employeeInfo")
    public String employeeInfo(){
        return "employeeInfo";
    }
}
