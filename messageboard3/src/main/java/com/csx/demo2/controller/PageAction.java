package com.csx.demo2.controller;

import com.csx.demo2.entity.PageBean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.UnsupportedEncodingException;

@Controller
public class PageAction {

    /**
     * 上一页
     *
     * @param req
     * @return
     * @throws UnsupportedEncodingException
     */
    @RequestMapping("lastPageForMessage")
    public String lastPageForMessage(HttpServletRequest req) throws UnsupportedEncodingException {
        req.setCharacterEncoding("UTF-8");
        HttpSession session = req.getSession();
        PageBean pageBean = (PageBean) session.getAttribute("pageBean");
        pageBean.minusPageNumber();//当前页数减一
        session.setAttribute("pageBean", pageBean);
        return "redirect:" + "message";
    }

    /**
     * 下一页
     *
     * @param req
     * @return
     * @throws UnsupportedEncodingException
     */
    @RequestMapping("nextPageForMessage")
    public String nextPageForMessage(HttpServletRequest req) throws UnsupportedEncodingException {
        req.setCharacterEncoding("UTF-8");
        HttpSession session = req.getSession();
        PageBean pageBean = (PageBean) session.getAttribute("pageBean");
        pageBean.addPageNumber();//当前页数加一
        session.setAttribute("pageBean", pageBean);
        return "redirect:" + "message";
    }

    @RequestMapping("lastPageForLog")
    public String LastPageForLogController(HttpServletRequest req) throws UnsupportedEncodingException {
        req.setCharacterEncoding("UTF-8");
        HttpSession session = req.getSession();
        PageBean pageBeanForLog = (PageBean) session.getAttribute("pageBeanForLog");
        pageBeanForLog.minusPageNumber();//当前页数减一
        session.setAttribute("pageBeanForLog", pageBeanForLog);
        return "redirect:" + "log";
    }

    @RequestMapping("nextPageForLog")
    public String NextPageForLogController(HttpServletRequest req) throws UnsupportedEncodingException {
        req.setCharacterEncoding("UTF-8");
        HttpSession session = req.getSession();
        PageBean pageBeanForLog = (PageBean) session.getAttribute("pageBeanForLog");
        pageBeanForLog.addPageNumber();//当前页数加一
        session.setAttribute("pageBeanForLog", pageBeanForLog);
        return "redirect:" + "log";
    }
}
