package com.csx.demo2.service;

import com.csx.demo2.dao.RoleDao;
import com.csx.demo2.entity.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleService {

    @Autowired
    private RoleDao roleDao;

    /**
     * 查询所有的角色
     * @return
     */

    public List<Role> selectAllRole( ){
        List<Role> roles = roleDao.select(new Role(null, null));
        return roles;
    }

    /*
    * 根据角色id  查询该角色的信息
    * */
    public Role selectByRoleId(String roleid){
        Role role = roleDao.select(new Role(Integer.valueOf(roleid), null)).get(0);
        return role;
    }

}
