package com.csx.demo2.service;

import com.csx.demo2.dao.RoleDao;
import com.csx.demo2.entity.Role;
import com.csx.demo2.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleService {

    @Autowired
    private RoleDao roleDao;

    public List<Role> selectAllRole( ){
        List<Role> roles = roleDao.select(new Role(null, null));
        return roles;
    }

    public Role selectByRoleId(String roleid){
        Role role = roleDao.select(new Role(Integer.valueOf(roleid), null)).get(0);
        return role;
    }

}
