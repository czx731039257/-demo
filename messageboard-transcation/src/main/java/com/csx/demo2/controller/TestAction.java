package com.csx.demo2.controller;

import com.csx.demo2.dao.MessageDao;
import com.csx.demo2.entity.Message;
import com.csx.demo2.entity.Result;
import com.csx.demo2.entity.TestResult;
import com.csx.demo2.entity.User;
import com.csx.demo2.service.MessageService;
import com.csx.demo2.service.UserService;
import net.minidev.json.JSONObject;
import org.hibernate.validator.constraints.URL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.List;

@Controller
public class TestAction {

    @Autowired
    private UserService userService;

    @Autowired
    private MessageDao messageDao;

    @Autowired
    private MessageService messageService;

    @ResponseBody
    @RequestMapping("/test1")
    public List<Message> test1(){
        Result result = messageService.selectAllMessage();
        return result.getMessages();
    }

    @ResponseBody
    @RequestMapping(value="/saveUser",method = RequestMethod.POST)
    public void saveMessage(@RequestBody String message,HttpServletResponse resp){
        resp.setContentType("application/json;charset=utf-8");
        System.out.println(message);
    }
}
