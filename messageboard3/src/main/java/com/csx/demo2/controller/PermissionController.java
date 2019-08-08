package com.csx.demo2.controller;

import com.csx.demo2.entity.Permission;
import com.csx.demo2.entity.Role;
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

    @RequestMapping("/editpermissioncontroller")
    public String editpermissioncontroller(HttpServletRequest req) throws UnsupportedEncodingException {
        req.setCharacterEncoding("UTF-8");
        HttpSession session = req.getSession();
        String roleid = req.getParameter("roleid");
        List<Permission> haspermissions = permissionService.selectByRoleId(Integer.valueOf(roleid));
        Role role = roleService.selectByRoleId(roleid);
        session.setAttribute("role",role);
        session.setAttribute("haspermissions",haspermissions);
        return "redirect:"+"permission";
    }


    @RequestMapping("/editpermissionsuccess")
    public String editpermissionsuccess(HttpServletRequest req) throws UnsupportedEncodingException {
        req.setCharacterEncoding("UTF-8");
        HttpSession session = req.getSession();
        Role role = (Role)session.getAttribute("role");
        List<Permission> haspermissions = (List<Permission>) session.getAttribute("haspermissions");
        String[] permissions = req.getParameterValues("permission");

        for(String i :permissions){
            System.out.println(i);
        }
        rolePermissionService.changeRolePermission(haspermissions,permissions,role.getId());
        haspermissions = permissionService.selectByRoleId(Integer.valueOf(role.getId()));

        session.setAttribute("haspermissions",haspermissions);
        return "redirect:"+"permission";
    }
}
