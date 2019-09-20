package com.csx.demo2.service;

import com.csx.demo2.dao.PermissionDao;
import com.csx.demo2.entity.Permission;
import com.csx.demo2.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PermissionService {

    @Autowired
    private PermissionDao permissionDao;

    /**
     * 根据用户名查看该用户的所有权限
     * @return
     */
    public List<Permission> selectPermissionByUserName(String username){
        List<Permission> permissions = permissionDao.selectByUserName(username);
        return permissions;
    }
}
