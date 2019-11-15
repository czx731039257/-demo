package com.csx.demo2.controller;

import com.csx.demo2.entity.User;
import com.csx.demo2.service.PermissionService;
import com.csx.demo2.service.UserRoleService;
import com.csx.demo2.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.flyway.FlywayDataSource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private PermissionService permissionService;

    @Autowired
    private UserRoleService userRoleService;

    /**
     * 查询所有用户信息
     *
     * @param req
     * @return
     * @throws ServletException
     * @throws IOException
     */
    @RequestMapping("SelectAllUserInfoController")//
    public String allusercontroller(HttpServletRequest req) throws ServletException, IOException {
        HttpSession session = req.getSession();

        List<User> users = userService.selectAllUserInfo();//调用业务层

        session.setAttribute("users", users);
        return "redirect:" + "users";
    }

    /**
     * 查询个人用户信息
     *
     * @param req
     * @return
     * @throws UnsupportedEncodingException
     */
    @RequestMapping("PersonInfoController")//
    public String usercontroller(HttpServletRequest req) throws UnsupportedEncodingException {
        req.setCharacterEncoding("UTF-8");
        HttpSession session = req.getSession();
        User user = (User) session.getAttribute("user");

        user = userService.selectPersonInfo(user);//调用业务层

        session.setAttribute("user", user);
        return "redirect:" + "person";
    }

    /**
     * @param req
     * @return
     * @throws UnsupportedEncodingException
     */
    @RequestMapping("EditPersonInfoSuccessController")//
    public String editusercontroller(HttpServletRequest req) throws UnsupportedEncodingException {
        req.setCharacterEncoding("UTF-8");
        HttpSession session = req.getSession();
        String name = req.getParameter("name");
        String password = req.getParameter("password");
        String email = req.getParameter("email");
        String phone = req.getParameter("phone");

        User user = (User) session.getAttribute("user");
        user = userService.editPersonInfo(user, name, password, email, phone);//调用业务层

        session.setAttribute("user", user);
        return "redirect:" + "person";
    }

    @RequestMapping("EditUserInfoController")
    public String editUserController(HttpServletRequest req) throws UnsupportedEncodingException {
        req.setCharacterEncoding("UTF-8");
        HttpSession session = req.getSession();
        String userid = req.getParameter("userid");
        User edituser = userService.editUserInfo(userid);
        session.setAttribute("edituser", edituser);
        return "redirect:" + "edituser";
    }


    @RequestMapping("EditUserInfoSuccessController")
    public String EditPersonInfoSuccessController(HttpServletRequest req) throws UnsupportedEncodingException {
        req.setCharacterEncoding("UTF-8");
        HttpSession session = req.getSession();
        List<User> users = (List<User>) session.getAttribute("users");
        String id = req.getParameter("id");
        String name = req.getParameter("name");
        String password = req.getParameter("password");
        String email = req.getParameter("email");
        String phone = req.getParameter("phone");
        String group_id = req.getParameter("group_id");
        users = userService.editUserInfoSuccess(users, id, name, password, email, phone, group_id);
        session.setAttribute("users", users);
        return "redirect:" + "users";
    }


    @RequestMapping("CancelUserController")
    public String cancelcontroller(HttpServletRequest req) throws UnsupportedEncodingException {
        req.setCharacterEncoding("UTF-8");
        HttpSession session = req.getSession();
        session.removeAttribute("user");//从session域中删除user
        session.removeAttribute("pageBean");
        session.removeAttribute("messageSet");
        permissionService.removeSessionPermission(session);
        session.invalidate();
        return "redirect:" + "login";
    }

    @RequestMapping("SelectGroupUserInfoController")//
    public String selectGroupUserInfoController(HttpServletRequest req) throws ServletException, IOException {
        HttpSession session = req.getSession();
        User user = (User) session.getAttribute("user");
        List<User> users = userService.selectGroupUserInfo(user);//调用业务层
        session.setAttribute("users", users);
        return "redirect:" + "users";
    }

    @RequestMapping("SelectOtherGroupUserInfoController")//
    public String selectOtherGroupUserInfoController(HttpServletRequest req) throws ServletException, IOException {
        HttpSession session = req.getSession();
        User user = (User) session.getAttribute("user");
        List<User> users = userService.selectOtherGroupUserInfo(user);//调用业务层
        session.setAttribute("users", users);
        return "redirect:" + "users";
    }


    /**
     * 给用户分配角色
     *
     * @param req
     * @return
     * @throws ServletException
     * @throws IOException
     */
    @RequestMapping("allocationcontroller")//
    public String allocationcontroller(HttpServletRequest req) throws ServletException, IOException {
        HttpSession session = req.getSession();
        List<User> usersandrole = userRoleService.selectAllUserAndRole();//获取带有角色集合的用户对象 的集合
        session.setAttribute("usersandrole", usersandrole);
        return "redirect:" + "allocation";
    }
}
