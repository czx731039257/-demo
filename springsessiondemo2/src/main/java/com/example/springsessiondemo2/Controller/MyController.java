package com.example.springsessiondemo2.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class MyController {

    @ResponseBody
    @RequestMapping("/set")
    public String setsession(HttpServletRequest req){
        HttpSession session = req.getSession();
        String str="这里是8090端口的服务器";
        System.out.println("str");
        session.setAttribute("msg",str);
        return str;
    }

    @ResponseBody
    @RequestMapping("/get")
    public String getsession(HttpServletRequest req){
        HttpSession session = req.getSession();
        String id=session.getId();
        String msg = (String)session.getAttribute("msg");
        System.out.println("获取导的msg："+msg);
        return "获取导的msg："+msg+"\n当前的jsessionid="+id;
    }
}
