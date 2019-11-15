package com.csx.demo2.service;

import com.csx.demo2.dao.PermissionDao;
import com.csx.demo2.entity.Permission;
import com.csx.demo2.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.Iterator;
import java.util.List;

@Service
public class PermissionService {

    @Autowired
    private PermissionDao permissionDao;

    /*
     * 查询该角色的所有权限
     * */
    public List<Permission> selectByRoleId(Integer roleid) {
        List<Permission> permissions = permissionDao.selectByRoleId(roleid);
        return permissions;
    }

    /*
     * 查询所有的权限
     * */
    public List<Permission> selectAll() {
        List<Permission> permissions = permissionDao.selectAll();
        return permissions;
    }

    /**
     * 查询 某个用户的所有权限
     *
     * @param user
     * @return
     */
    public List<Permission> selectByUser(User user) {
        List<Permission> permissions = permissionDao.select(user);
        return permissions;
    }
}
