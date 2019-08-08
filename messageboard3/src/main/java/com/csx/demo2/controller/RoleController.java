package com.csx.demo2.controller;

import com.csx.demo2.entity.Permission;
import com.csx.demo2.entity.Role;
import com.csx.demo2.entity.User;
import com.csx.demo2.service.PermissionService;
import com.csx.demo2.service.RoleService;
import com.csx.demo2.service.UserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.UnsupportedEncodingException;
import java.util.Iterator;
import java.util.List;

@Controller
public class RoleController {

    @Autowired
    private RoleService roleService;

    @Autowired
    private PermissionService permissionService;

    @Autowired
    private UserRoleService userRoleService;

    @RequestMapping("/selectrole")
    public String selectrole(HttpServletRequest req) throws UnsupportedEncodingException {
        req.setCharacterEncoding("UTF-8");
        HttpSession session = req.getSession();
        List<Role> roles = roleService.selectAllRole();
        List<Permission> allpermissions = permissionService.selectAll();
        session.setAttribute("allpermissions",allpermissions);
        session.setAttribute("roles",roles);
        return "redirect:"+"roles";
    }


    @RequestMapping("/editrolesuccesscontroller")
    public String editrolesuccesscontroller(HttpServletRequest req) throws UnsupportedEncodingException {
        req.setCharacterEncoding("UTF-8");
        HttpSession session = req.getSession();
        String userid = req.getParameter("userid");
        String[] hasroles = req.getParameterValues("hasroles");
        List<User> usersandrole = (List<User>)session.getAttribute("usersandrole");
        Iterator<User> it=usersandrole.iterator();
        List<Role> roles=null;
        while(it.hasNext()){
            User user=it.next();
            if(user.getId()==Integer.valueOf(userid)){
                roles = user.getRoles();
            }
        }
        userRoleService.changeUserRole(Integer.valueOf(userid),hasroles,roles);
        System.out.println("用户id:"+userid);
        for(String str:hasroles){
            System.out.println(str);
        }
        usersandrole = userRoleService.selectAllUserAndRole();
        session.setAttribute("usersandrole",usersandrole);
        return "redirect:"+"allocation";
    }
}
