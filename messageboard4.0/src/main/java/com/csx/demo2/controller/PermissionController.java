package com.csx.demo2.controller;

import com.csx.demo2.entity.Permission;
import com.csx.demo2.entity.Role;
import com.csx.demo2.entity.User;
import com.csx.demo2.service.PermissionService;
import com.csx.demo2.service.RolePermissionService;
import com.csx.demo2.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.UnsupportedEncodingException;
import java.util.List;

@Controller
public class PermissionController {

    @Autowired
    private PermissionService permissionService;

    @Autowired
    private RoleService roleService;

    @Autowired
    private RolePermissionService rolePermissionService;


    /**
     * roles.jsp页面中的 编辑角色的权限
     */
    @RequestMapping("/editpermissioncontroller")//
    public String editpermissioncontroller(HttpServletRequest req) throws UnsupportedEncodingException {
        req.setCharacterEncoding("UTF-8");
        HttpSession session = req.getSession();
        String roleid = req.getParameter("roleid");//获取从前端传来的所需查询的角色id
        List<Permission> haspermissions = permissionService.selectByRoleId(Integer.valueOf(roleid));//该角色所具有是权限集合
        Role role = roleService.selectByRoleId(roleid);//查询该角色的基本信息

        session.setAttribute("role", role);
        session.setAttribute("haspermissions", haspermissions);
        return "redirect:" + "permission";
    }

    /**
     * permission.jsp页面中的保存 当前给角色编辑的权限
     *
     * @param req
     * @return
     * @throws UnsupportedEncodingException
     */
    @RequestMapping("/editpermissionsuccess")//
    public String editpermissionsuccess(HttpServletRequest req) throws UnsupportedEncodingException {
        req.setCharacterEncoding("UTF-8");
        HttpSession session = req.getSession();
        Role role = (Role) session.getAttribute("role");//获取当前编辑的角色对象
        List<Permission> haspermissions = (List<Permission>) session.getAttribute("haspermissions");//当前编辑角色所具有的所有权限集合
        String[] permissions = req.getParameterValues("permission");
        rolePermissionService.changeRolePermission(haspermissions, permissions, role.getId());//更改数据库中role_permission数据
        haspermissions = permissionService.selectByRoleId(Integer.valueOf(role.getId()));//更新当前编辑角色的所有权限

        List<Permission> olduserpermissions = (List<Permission>) session.getAttribute("permissions");//获取当前使用用户的 旧的权限
        List<Permission> newuserpermissions = permissionService.selectByUser((User) session.getAttribute("user"));
        permissionService.removeSessionPermission(session);//清空session中的所有权限对象
        permissionService.addSessionPermission(session, newuserpermissions);//把重新得到的权限 注入session
        session.setAttribute("permissions", newuserpermissions);
        session.setAttribute("haspermissions", haspermissions);
        return "redirect:" + "permission";
    }
}
