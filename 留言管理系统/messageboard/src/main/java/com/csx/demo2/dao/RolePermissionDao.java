package com.csx.demo2.dao;

import com.csx.demo2.entity.RolePermission;
import org.springframework.stereotype.Repository;

@Repository
public interface RolePermissionDao {
    void insert(RolePermission rolePermission);
    void delete(RolePermission rolePermission);
}
