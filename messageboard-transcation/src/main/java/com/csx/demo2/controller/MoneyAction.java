package com.csx.demo2.controller;

import com.csx.demo2.entity.Pojo;
import com.csx.demo2.entity.Result;
import com.csx.demo2.entity.User;
import com.csx.demo2.service.UserService;
import net.minidev.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

@Controller
public class MoneyAction {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/recharge", method = RequestMethod.POST)
    public void recharge(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setCharacterEncoding("UTF-8");
        request.setCharacterEncoding("UTF-8");
        HttpSession session = request.getSession();
        StringBuffer myJson = new StringBuffer();

        BufferedReader reader = request.getReader();
        String money = reader.readLine();
        int i = money.indexOf('=');
        money = money.substring(i + 1);
        //System.out.println(money);
        User user = (User) session.getAttribute("user");
        Result result = userService.recharge(user, Integer.valueOf(money));
        session.setAttribute("user", result.getUser());

        response.setContentType("application/json;charset=utf-8");//指定返回的格式为JSON格式

        JSONObject ob = new JSONObject();//创建json对象
        ob.appendField("newmoney", result.getUser().getMoney());
        ob.appendField("rechargeresult", "充值成功！");//添加元素
        PrintWriter out = response.getWriter();
        out.print(ob);
        out.close();
    }

    @RequestMapping(value = "/reward", method = RequestMethod.GET)
    public void reward(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        HttpSession session = request.getSession();
        String money = request.getParameter("money");
        String addUserId = request.getParameter("userid");
        User user = (User) session.getAttribute("user");
        response.setContentType("application/json;charset=utf-8");//指定返回的格式为JSON格式
        JSONObject ob = new JSONObject();//创建json对象
        int flag = 0;
        Integer balance = null;
        try {
            balance = userService.reward(session, Integer.valueOf(addUserId), user, Integer.valueOf(money));
        } catch (RuntimeException e) {
            //e.printStackTrace();
            flag = 1;
            ob.appendField("rewardresult", "打赏失败！\n系统故障！");//添加元素
        }

        if (flag == 0) {
            ob.appendField("rewardresult", "打赏成功！");//添加元素
            ob.appendField("balance", balance);
        }
        PrintWriter out = response.getWriter();
        out.print(ob);
        out.close();
    }

}
