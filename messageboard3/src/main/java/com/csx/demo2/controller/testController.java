package com.csx.demo2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@Controller
public class testController {

    @RequestMapping("/testcontroller1")
    public String testcontroller1(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        String referer = req.getHeader("Referer");
        System.out.println("***************");
        System.out.println(referer);
        int i = referer.lastIndexOf('/')+1;
        referer=referer.substring(i);
        System.out.println(referer);
        HttpSession session = req.getSession();
        session.setAttribute("withoutPermission","true");
        return "redirect:"+referer;
    }

    @RequestMapping("/testcontroller2")
    public String testcontroller2(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        String[] str={"a","b","c","d"};
        req.getSession().setAttribute("str",str);
        return "redirect:"+"test1";
    }
}
