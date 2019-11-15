package com.csx.demo2.controller;

import com.csx.demo2.entity.BillItem;
import com.csx.demo2.entity.Result;
import com.csx.demo2.entity.User;
import com.csx.demo2.service.BillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Controller
public class BillAction {

    @Autowired
    private BillService billService;

    @RequestMapping("/queryBill")
    public String queryBill(HttpServletRequest req, HttpServletResponse resp) {
        HttpSession session = req.getSession();
        User user = (User) session.getAttribute("user");
        Result result = billService.selectBill(user.getId());
        session.setAttribute("bill", result.getBill());
        session.setAttribute("pageBeanForBill", result.getPageBean());
        return "redirect:" + "bill";
    }
}
