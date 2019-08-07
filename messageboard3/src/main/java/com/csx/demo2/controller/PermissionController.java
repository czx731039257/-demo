package com.csx.demo2.controller;

import com.csx.demo2.entity.Permission;
import com.csx.demo2.entity.Role;
import com.csx.demo2.service.PermissionService;
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

    @RequestMapping("/editpermissioncontroller")
    public String editpermissioncontroller(HttpServletRequest req) throws UnsupportedEncodingException {
        req.setCharacterEncoding("UTF-8");
        HttpSession session = req.getSession();
        String roleid = req.getParameter("roleid");
        List<Permission> haspermissions = permissionService.selectByRoleId(Integer.valueOf(roleid));
        List<Permission> permissions = permissionService.selectAll();
        session.setAttribute("permissions",permissions);
        session.setAttribute("haspermissions",haspermissions);
        return "permission";
    }
}
