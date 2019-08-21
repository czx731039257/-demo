package com.csx.demo2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.UnsupportedEncodingException;

@Controller
public class LogoutAction {

    /**
     * 注销时的操作
     * @param req
     * @return
     * @throws UnsupportedEncodingException
     */
    @RequestMapping("logout")
    public String logout(HttpServletRequest req) throws UnsupportedEncodingException {
        req.setCharacterEncoding("UTF-8");
        HttpSession session = req.getSession();
        session.invalidate();
        return "redirect:"+"login";
    }
}
