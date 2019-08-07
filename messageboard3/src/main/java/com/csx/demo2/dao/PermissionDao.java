package com.csx.demo2.dao;

import com.csx.demo2.entity.Permission;
import com.csx.demo2.entity.Role;
import com.csx.demo2.entity.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PermissionDao {
   List<Permission> select(User user);
   List<Permission> selectByRole(Role role);
   List<Permission> selectAll();
}
