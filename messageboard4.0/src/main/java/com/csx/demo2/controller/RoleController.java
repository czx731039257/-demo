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


    /**
     * 查看所有的角色
     */
    @RequestMapping("/selectrole")//
    public String selectrole(HttpServletRequest req) throws UnsupportedEncodingException {
        req.setCharacterEncoding("UTF-8");
        HttpSession session = req.getSession();
        List<Role> roles = roleService.selectAllRole();
        List<Permission> allpermissions = permissionService.selectAll();
        session.setAttribute("allpermissions",allpermissions);
        session.setAttribute("roles",roles);
        return "redirect:"+"roles";
    }


    /**
     * 保存给用户分配角色
     * @param req
     * @return
     * @throws UnsupportedEncodingException
     */
    @RequestMapping("/editrolesuccesscontroller")//
    public String editrolesuccesscontroller(HttpServletRequest req) throws UnsupportedEncodingException {
        req.setCharacterEncoding("UTF-8");
        HttpSession session = req.getSession();
        String userid = req.getParameter("userid");
        String[] hasroles = req.getParameterValues("hasroles");
        List<User> usersandrole = (List<User>)session.getAttribute("usersandrole");
        Iterator<User> it=usersandrole.iterator();
        List<Role> roles=null;
        while(it.hasNext()){//定位需要更改的角色
            User user=it.next();
            if(user.getId()==Integer.valueOf(userid)){
                roles = user.getRoles();
            }
        }
        userRoleService.changeUserRole(Integer.valueOf(userid),hasroles,roles);

        usersandrole = userRoleService.selectAllUserAndRole();//更新
        List<Permission> newuserpermissions = permissionService.selectByUser((User) session.getAttribute("user"));
        session.setAttribute("usersandrole",usersandrole);
        session.setAttribute("permissions",newuserpermissions);
        permissionService.removeSessionPermission(session);
        permissionService.addSessionPermission(session,newuserpermissions);
        return "redirect:"+"allocation";
    }
}
