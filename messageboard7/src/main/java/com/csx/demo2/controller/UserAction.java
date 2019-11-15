package com.csx.demo2.controller;

import com.csx.demo2.entity.HeadPortrait;
import com.csx.demo2.entity.Result;
import com.csx.demo2.entity.User;
import com.csx.demo2.service.HeadPortraitService;
import com.csx.demo2.service.PermissionService;
import com.csx.demo2.service.UserRoleService;
import com.csx.demo2.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.AuthorizationException;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.UUID;

@Controller
public class UserAction {

    @Autowired
    private UserService userService;

    @Autowired
    private UserRoleService userRoleService;

    @Autowired
    private HeadPortraitService headPortraitService;

    /**
     * 查询个人用户信息
     *
     * @param req
     * @return
     * @throws UnsupportedEncodingException
     */
    @RequiresPermissions({"浏览自己的用户信息"})
    @RequestMapping("/queryPersonInfo")//
    public String queryPersonInfo(HttpServletRequest req) throws UnsupportedEncodingException {
        req.setCharacterEncoding("UTF-8");
        HttpSession session = req.getSession();
        User user = (User) session.getAttribute("user");

        user = userService.selectPersonInfo(user);//调用业务层

        session.setAttribute("logmsg", "成功");
        session.setAttribute("user", user);
        return "redirect:" + "person";
    }

    /**
     * 浏览所在用户组的人的用户信息
     *
     * @param req
     * @return
     * @throws ServletException
     * @throws IOException
     */
    @RequiresPermissions({"浏览所在用户组的人的用户信息"})
    @RequestMapping("/querySameGroupUserInfo")//
    public String querySameGroupUserInfo(HttpServletRequest req) throws ServletException, IOException {
        HttpSession session = req.getSession();
        User user = (User) session.getAttribute("user");
        List<User> users = userService.selectGroupUserInfo(user);//调用业务层
        session.setAttribute("logmsg", "成功");
        session.setAttribute("users", users);
        return "redirect:" + "users";
    }

    /**
     * 浏览其他用户组的人的用户信息
     *
     * @param req
     * @return
     * @throws ServletException
     * @throws IOException
     */
    @RequiresPermissions({"浏览其他用户组的人的用户信息"})
    @RequestMapping("/queryOtherGroupUserInfo")//
    public String queryOtherGroupUserInfo(HttpServletRequest req) throws ServletException, IOException {
        HttpSession session = req.getSession();
        User user = (User) session.getAttribute("user");
        List<User> users = userService.selectOtherGroupUserInfo(user);//调用业务层
        session.setAttribute("logmsg", "成功");
        session.setAttribute("users", users);
        return "redirect:" + "users";
    }


    /**
     * 查询所有用户信息
     *
     * @param req
     * @return
     * @throws ServletException
     * @throws IOException
     */
    @RequiresPermissions({"浏览自己的用户信息", "浏览所在用户组的人的用户信息", "浏览其他用户组的人的用户信息"})
    @RequestMapping("/queryAllUserInfo")
    public String queryAllUserInfo(HttpServletRequest req) throws ServletException, IOException {
        HttpSession session = req.getSession();
        List<User> users = userService.selectAllUserInfo();//调用业务层
        session.setAttribute("users", users);
        return "redirect:" + "users";
    }


    /**
     * 成功保存编辑后的个人用户信息
     *
     * @param req
     * @return
     * @throws UnsupportedEncodingException
     */
    @RequiresPermissions({"编辑自己的用户信息"})
    @RequestMapping("editPersonInfoSuccess")//
    public String editPersonInfoSuccess(HttpServletRequest req) throws UnsupportedEncodingException {
        req.setCharacterEncoding("UTF-8");
        HttpSession session = req.getSession();
        String name = req.getParameter("name");
        String password = req.getParameter("password");
        String email = req.getParameter("email");
        String phone = req.getParameter("phone");

        User user = (User) session.getAttribute("user");
        user = userService.editPersonInfo(user, name, password, email, phone);//调用业务层

        session.setAttribute("logmsg", "成功");
        session.setAttribute("user", user);
        return "redirect:" + "person";
    }

    /**
     * 进入编辑用户信息页面时的操作
     *
     * @param req
     * @return
     * @throws UnsupportedEncodingException
     */
    @RequestMapping("/intoEditUserInfo")//
    public String intoEditUserInfo(HttpServletRequest req) throws UnsupportedEncodingException {
        req.setCharacterEncoding("UTF-8");
        HttpSession session = req.getSession();
        User user = (User) session.getAttribute("user");
        String userid = req.getParameter("userid");
        User usertemp = userService.selectPersonInfo(new User(Integer.valueOf(userid), null, null, null, null, null));

        Subject subject = SecurityUtils.getSubject();
        if (user.getId() == usertemp.getId()) {
            if (!subject.isPermitted("编辑自己的用户信息")) {
                throw new AuthorizationException();
            }
        } else {
            if (user.getGroup_id() == usertemp.getGroup_id()) {
                if (!subject.isPermitted("编辑所在用户组的人的用户信息")) {
                    throw new AuthorizationException();
                }
            } else {
                if (!subject.isPermitted("编辑其他用户组的人的用户信息")) {
                    throw new AuthorizationException();
                }
            }
        }


        User edituser = userService.editUserInfo(userid);
        session.setAttribute("edituser", edituser);
        return "redirect:" + "edituser";
    }


    /**
     * 成功保存编辑后的用户信息
     *
     * @param req
     * @return
     * @throws UnsupportedEncodingException
     */
    @RequestMapping("/editUserInfoSuccess")
    public String editUserInfoSuccess(HttpServletRequest req) throws UnsupportedEncodingException {
        req.setCharacterEncoding("UTF-8");
        HttpSession session = req.getSession();
        List<User> users = (List<User>) session.getAttribute("users");

        User user = (User) session.getAttribute("user");
        String userid = req.getParameter("userid");
        User usertemp = userService.selectPersonInfo(new User(Integer.valueOf(userid), null, null, null, null, null));
        Subject subject = SecurityUtils.getSubject();
        if (user.getId() == usertemp.getId()) {
            if (!subject.isPermitted("编辑自己的用户信息")) {
                throw new AuthorizationException();
            }
        } else {
            if (user.getGroup_id() == usertemp.getGroup_id()) {
                if (!subject.isPermitted("编辑所在用户组的人的用户信息")) {
                    throw new AuthorizationException();
                }
            } else {
                if (!subject.isPermitted("编辑其他用户组的人的用户信息")) {
                    throw new AuthorizationException();
                }
            }
        }


        String id = req.getParameter("userid");
        String name = req.getParameter("name");
        String password = req.getParameter("password");
        String email = req.getParameter("email");
        String phone = req.getParameter("phone");
        String group_id = req.getParameter("group_id");
        users = userService.editUserInfoSuccess(users, id, name, password, email, phone, group_id);
        session.setAttribute("logmsg", "成功");
        session.setAttribute("users", users);
        return "redirect:" + "users";
    }


    /**
     * 上传头像
     *
     * @param req
     * @return
     * @throws ServletException
     * @throws IOException
     */
    @RequestMapping("/uploadHead")
    public String uploadHead(HttpServletRequest req, MultipartFile file) throws IOException {
        HttpSession session = req.getSession();
        User user = (User) session.getAttribute("user");
        String url = req.getSession().getServletContext().getRealPath("/userhead");
        url += "/";
        String originalFilename = file.getOriginalFilename();
        if (originalFilename == null || "".equals(originalFilename)) {
            session.setAttribute("uploaderror", "请不要上传空文件！");
            return "redirect:" + "editperson";
        } else {
            int i = originalFilename.lastIndexOf('.');
            String substring = originalFilename.substring(i + 1);
            System.out.println(substring);
            if (!substring.equals("jpg")) {
                session.setAttribute("uploaderror", "请上传JPG格式的图片！");
                return "redirect:" + "editperson";
            }
        }

        String filename = UUID.randomUUID() + originalFilename;
        file.transferTo(new File(url + filename));
        Result result = headPortraitService.insert(user, new HeadPortrait(null, user.getId(), "userhead/" + filename));
        System.out.println(user);
        session.setAttribute("user", result.getUser());
        return "redirect:" + "editperson";
    }


    /**
     * 选择头像
     *
     * @param req
     * @param file
     * @return
     * @throws IOException
     */
    @RequestMapping("/changeHead")
    public String changeHead(HttpServletRequest req, MultipartFile file) throws IOException {
        HttpSession session = req.getSession();
        User user = (User) session.getAttribute("user");
        String head = req.getParameter("head");
        user = userService.editPersonHead(user, Integer.valueOf(head));
        session.setAttribute("user", user);
        return "redirect:" + "editperson";
    }


    /**
     * 账户充值
     *
     * @param req
     * @param
     * @return
     * @throws IOException
     */
    @RequestMapping("/rechargeSuccess")
    public String rechargeSuccess(HttpServletRequest req) throws IOException {
        String money = req.getParameter("money");
        HttpSession session = req.getSession();
        User user = (User) session.getAttribute("user");
        Result result = userService.recharge(user, Integer.valueOf(money));
        session.setAttribute("user", result.getUser());
        return "redirect:" + "person";
    }

    @RequestMapping("/rewardSuccess")
    public String rewardSuccess(HttpServletRequest req) throws IOException {
        String money = req.getParameter("money");
        HttpSession session = req.getSession();
        String messagehostid = (String) session.getAttribute("messagehostid");
        User user = (User) session.getAttribute("user");
        userService.reward(session, Integer.valueOf(messagehostid), user.getId(), Integer.valueOf(money));
        return "redirect:" + "message";
    }
}
