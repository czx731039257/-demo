package com.csx.demo2.dao;

import com.csx.demo2.entity.Role;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoleDao {
    public List<Role> select(Role role);

}
