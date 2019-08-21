package com.csx.demo2.controller;

import com.csx.demo2.entity.Permission;
import com.csx.demo2.entity.Role;
import com.csx.demo2.entity.User;
import com.csx.demo2.service.PermissionService;
import com.csx.demo2.service.RoleService;
import com.csx.demo2.service.UserRoleService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Iterator;
import java.util.List;

@Controller
public class RoleAction {

    @Autowired
    private RoleService roleService;

    @Autowired
    private PermissionService permissionService;

    @Autowired
    private UserRoleService userRoleService;


    /**
     * 查看所有的角色
     */
    @RequiresPermissions({"给用户分配角色和权限"})
    @RequestMapping("/queryAllRoles")
    public String queryAllRoles(HttpServletRequest req) throws UnsupportedEncodingException {
        req.setCharacterEncoding("UTF-8");
        HttpSession session = req.getSession();
        List<Role> roles = roleService.selectAllRole();
        List<Permission> allpermissions = permissionService.selectAll();
        session.setAttribute("logmsg","成功");
        session.setAttribute("allpermissions",allpermissions);
        session.setAttribute("roles",roles);
        return "redirect:"+"roles";
    }


    /**
     * 给用户分配角色
     * @param req
     * @return
     * @throws ServletException
     * @throws IOException
     */
    @RequiresPermissions({"给用户分配角色和权限"})
    @RequestMapping("/intoEditUsersHasRoles")//
    public String intoEditUsersHasRoles(HttpServletRequest req) throws ServletException, IOException {
        HttpSession session = req.getSession();
        List<User> usersandrole = userRoleService.selectAllUserAndRole();//获取带有角色集合的用户对象 的集合
        session.setAttribute("logmsg","成功");
        session.setAttribute("usersandrole",usersandrole);
        return "redirect:"+"allocation";
    }


    /**
     * 保存给用户分配的角色
     * @param req
     * @return
     * @throws UnsupportedEncodingException
     */
    @RequiresPermissions({"给用户分配角色和权限"})
    @RequestMapping("/editUsersHaveRolesSuccess")//
    public String editUsersHaveRoles(HttpServletRequest req) throws UnsupportedEncodingException {
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
        session.setAttribute("logmsg","成功");
        return "redirect:"+"allocation";
    }
}
