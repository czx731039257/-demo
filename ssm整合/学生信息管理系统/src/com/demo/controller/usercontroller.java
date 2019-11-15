package com.demo.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.demo.entity.User;
import com.demo.service.StudentService;
import com.demo.service.UserService;

@RequestMapping("user")
@Controller
public class usercontroller {

    @Resource(name = "userService")
    private UserService userservice;

    @RequestMapping("login")
    public String login(User user) {
        if (userservice.login(user)) {
            return "index";
        } else {
            return "login";
        }
    }
}
