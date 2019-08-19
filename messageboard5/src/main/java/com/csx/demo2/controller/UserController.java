package com.csx.demo2.controller;

import com.csx.demo2.entity.HeadPortrait;
import com.csx.demo2.entity.Result;
import com.csx.demo2.entity.User;
import com.csx.demo2.service.HeadPortraitService;
import com.csx.demo2.service.PermissionService;
import com.csx.demo2.service.UserRoleService;
import com.csx.demo2.service.UserService;
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
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private PermissionService permissionService;

    @Autowired
    private UserRoleService userRoleService;

    @Autowired
    private HeadPortraitService headPortraitService;

    /**
     * 查询所有用户信息
     * @param req
     * @return
     * @throws ServletException
     * @throws IOException
     */
    @RequestMapping("SelectAllUserInfoController")//
    public String SelectAllUserInfoController(HttpServletRequest req) throws ServletException, IOException {
        HttpSession session = req.getSession();

        List<User> users = userService.selectAllUserInfo();//调用业务层

        session.setAttribute("users",users);
        return "redirect:"+"users";
    }

    /**
     * 查询个人用户信息
     * @param req
     * @return
     * @throws UnsupportedEncodingException
     */
    @RequestMapping("PersonInfoController")//
    public String PersonInfoController(HttpServletRequest req) throws UnsupportedEncodingException {
        req.setCharacterEncoding("UTF-8");
        HttpSession session = req.getSession();
        User user = (User)session.getAttribute("user");

        user = userService.selectPersonInfo(user);//调用业务层

        session.setAttribute("logmsg","成功");
        session.setAttribute("user",user);
        return "redirect:"+"person";
    }

    /**
     *
     * @param req
     * @return
     * @throws UnsupportedEncodingException
     */
    @RequestMapping("EditPersonInfoSuccessController")//
    public String EditPersonInfoSuccessController(HttpServletRequest req) throws UnsupportedEncodingException {
            req.setCharacterEncoding("UTF-8");
            HttpSession session = req.getSession();
            String name = req.getParameter("name");
            String password = req.getParameter("password");
            String email = req.getParameter("email");
            String phone = req.getParameter("phone");

            User user = (User)session.getAttribute("user");
            user = userService.editPersonInfo(user, name, password, email, phone);//调用业务层

            session.setAttribute("logmsg","成功");
            session.setAttribute("user",user);
            return "redirect:"+"person";
    }

    @RequestMapping("EditUserInfoController")//
    public String EditUserInfoController(HttpServletRequest req) throws UnsupportedEncodingException {
        req.setCharacterEncoding("UTF-8");
        HttpSession session = req.getSession();
        String userid=req.getParameter("userid");
        User edituser = userService.editUserInfo(userid);
        session.setAttribute("edituser",edituser);
        return "redirect:"+"edituser";
    }


    @RequestMapping("EditUserInfoSuccessController")
    public String EditUserInfoSuccessController(HttpServletRequest req) throws UnsupportedEncodingException {
        req.setCharacterEncoding("UTF-8");
        HttpSession session = req.getSession();
        List<User> users = (List<User>) session.getAttribute("users");
        String id = req.getParameter("id");
        String name = req.getParameter("name");
        String password = req.getParameter("password");
        String email=req.getParameter("email");
        String phone = req.getParameter("phone");
        String group_id = req.getParameter("group_id");
        users = userService.editUserInfoSuccess(users, id, name, password, email, phone, group_id);
        session.setAttribute("logmsg","成功");
        session.setAttribute("users",users);
        return "redirect:"+"users";
    }


    @RequestMapping("CancelUserController")
    public String CancelUserController(HttpServletRequest req) throws UnsupportedEncodingException {
        req.setCharacterEncoding("UTF-8");
        HttpSession session = req.getSession();
        session.removeAttribute("user");//从session域中删除user
        session.removeAttribute("pageBean");
        session.removeAttribute("messageSet");
        session.setAttribute("logmsg","成功");
        permissionService.removeSessionPermission(session);
        session.invalidate();
        return "redirect:"+"login";
    }

    @RequestMapping("SelectGroupUserInfoController")//
    public String SelectGroupUserInfoController(HttpServletRequest req) throws ServletException, IOException {
        HttpSession session = req.getSession();
        User user = (User)session.getAttribute("user");
        List<User> users = userService.selectGroupUserInfo(user);//调用业务层
        session.setAttribute("logmsg","成功");
        session.setAttribute("users",users);
        return "redirect:"+"users";
    }

    @RequestMapping("SelectOtherGroupUserInfoController")//
    public String SelectOtherGroupUserInfoController(HttpServletRequest req) throws ServletException, IOException {
        HttpSession session = req.getSession();
        User user = (User)session.getAttribute("user");
        List<User> users = userService.selectOtherGroupUserInfo(user);//调用业务层
        session.setAttribute("logmsg","成功");
        session.setAttribute("users",users);
        return "redirect:"+"users";
    }


    /**
     * 给用户分配角色
     * @param req
     * @return
     * @throws ServletException
     * @throws IOException
     */
    @RequestMapping("allocationcontroller")//
    public String allocationcontroller(HttpServletRequest req) throws ServletException, IOException {
        HttpSession session = req.getSession();
        List<User> usersandrole = userRoleService.selectAllUserAndRole();//获取带有角色集合的用户对象 的集合
        session.setAttribute("logmsg","成功");
        session.setAttribute("usersandrole",usersandrole);
        return "redirect:"+"allocation";
    }


    /**
     * 上传头像
     * @param req
     * @return
     * @throws ServletException
     * @throws IOException
     */
    @RequestMapping("/uploadhead")
    public String uploadhead(HttpServletRequest req, MultipartFile file) throws IOException {
        HttpSession session = req.getSession();
        User user = (User)session.getAttribute("user");
        String url = req.getSession().getServletContext().getRealPath("/userhead");
        url+="/";
        String originalFilename = file.getOriginalFilename();
        if(originalFilename==null||"".equals(originalFilename)){
            session.setAttribute("uploaderror","请不要上传空文件！");
            return "redirect:"+"editperson";
        }else{
            int i = originalFilename.lastIndexOf('.');
            String substring = originalFilename.substring(i + 1);
            System.out.println(substring);
            if(!substring.equals("jpg")){
                session.setAttribute("uploaderror","请上传JPG格式的图片！");
                return "redirect:"+"editperson";
            }
        }

        String filename= UUID.randomUUID()+originalFilename;
        file.transferTo(new File(url+filename));
        Result result=headPortraitService.insert(user,new HeadPortrait(null,user.getId(),"userhead/"+filename));
        System.out.println(user);
        session.setAttribute("user",result.getUser());
        return "redirect:"+"editperson";
    }


    /**
     * 选择头像
     * @param req
     * @param file
     * @return
     * @throws IOException
     */
    @RequestMapping("/changehead")
    public String changehead(HttpServletRequest req, MultipartFile file) throws IOException {
        HttpSession session = req.getSession();
        User user = (User)session.getAttribute("user");
        String head = req.getParameter("head");
        user = userService.editPersonHead(user, Integer.valueOf(head));
        session.setAttribute("user",user);
        return "redirect:"+"editperson";
    }
}
