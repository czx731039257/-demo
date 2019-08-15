package com.csx.demo2.dao;

import com.csx.demo2.entity.Role;
import com.csx.demo2.entity.User;
import com.csx.demo2.entity.UserRole;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRoleDao {
    List<Role> select(User user);
    void insert(UserRole userRole);
    void delete(UserRole userRole);
}
