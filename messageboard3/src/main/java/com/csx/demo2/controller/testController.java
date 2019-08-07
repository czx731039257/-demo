package com.csx.demo2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@Controller
public class testController {

    @RequestMapping("/testcontroller1")
    public String testcontroller1(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        String[] frults = req.getParameterValues("frult");
        for(String i:frults){
            System.out.println(i);
        }
        return "test1";
    }

    @RequestMapping("/testcontroller2")
    public String testcontroller2(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        String[] str={"a","b","c","d"};
        req.getSession().setAttribute("str",str);
        return "test1";
    }
}
