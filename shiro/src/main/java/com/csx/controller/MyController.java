package com.csx.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MyController {
    /**
     * 访问login.jsp页面
     *
     * @return
     */
    @RequestMapping("/login")
    public String login() {
        return "login";
    }

    /**
     * 访问loginsuccess.jsp页面
     *
     * @return
     */
    @RequestMapping("/loginsuccess")
    public String loginsuccess() {
        return "loginsuccess";
    }
}
