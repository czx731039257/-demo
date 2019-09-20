package com.csx.demo2.controller;


import com.csx.demo2.dao.UserDao;
import com.csx.demo2.entity.Page;
import com.csx.demo2.entity.Result;
import com.csx.demo2.entity.StringUtils;
import com.csx.demo2.entity.User;
import com.csx.demo2.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@Controller
@RequestMapping("/user")
public class UserAction {

    @Autowired
    private UserService userService;

    @Autowired
    private UserDao userDao;

    /**
     * 查询用户信息  包含条件查询和查询全部
     * @param req
     * @return
     * @throws IOException
     */
    @ResponseBody
    @RequestMapping("/queryUsers")
    public Page queryAllUser(HttpServletRequest req) throws IOException {
        Integer pageNumber = Integer.valueOf(req.getParameter("page"));
        Integer pageSize = Integer.valueOf(req.getParameter("rows"));
        String username = req.getParameter("username");
        String userid = req.getParameter("userid");
        Page page=new Page.Builder().pageNumber(pageNumber).pageSize(pageSize).startIndex((pageNumber-1)*pageSize).build();
        User user=new User();
        if(StringUtils.isNoBlank(username)){
            user.setName(username);
            page.setUser(user);
        }
        if(StringUtils.isNoBlank(userid)){
            user.setName(userid);
            page.setUser(user);
        }
        page = userService.findpage(page);
        return page;
    }

    /**
     * 编辑用户信息
     * @return
     */
    @ResponseBody
    @RequestMapping("/editUser")
    public Result easyui_editUser(HttpServletRequest req){
        String name=req.getParameter("name");
        String email=req.getParameter("email");
        String phone=req.getParameter("phone");
        Integer userid=Integer.valueOf(req.getParameter("userid"));
        boolean i = userService.update(new User.Builder().id(userid).name(name).email(email).phone(phone).build());
        if(i) {
            return new Result.Builder().successMsg("编辑成功").build();
        }else{
            return new Result.Builder().errorMsg("编辑失败").build();
        }
    }
}
