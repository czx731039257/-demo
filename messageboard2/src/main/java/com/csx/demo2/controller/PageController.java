package com.csx.demo2.controller;

import com.csx.demo2.entity.PageBean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.UnsupportedEncodingException;

@Controller
public class PageController {


    @RequestMapping("LastPageController")
    public String lastpagecontroller(HttpServletRequest req) throws UnsupportedEncodingException {
        req.setCharacterEncoding("UTF-8");
        HttpSession session = req.getSession();
        PageBean pageBean = (PageBean) session.getAttribute("pageBean");
        pageBean.minusPageNumber();
        session.setAttribute("pageBean", pageBean);
        return "message";
    }

    @RequestMapping("NextPageController")
    public String nextpagecontroller(HttpServletRequest req) throws UnsupportedEncodingException {
        req.setCharacterEncoding("UTF-8");
        HttpSession session = req.getSession();
        PageBean pageBean = (PageBean) session.getAttribute("pageBean");
        pageBean.addPageNumber();
        session.setAttribute("pageBean", pageBean);
        return "message";
    }
}
