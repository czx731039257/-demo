package com.csx.demo2.service;

import com.csx.demo2.dao.RolePermissionDao;
import com.csx.demo2.entity.Permission;
import com.csx.demo2.entity.RolePermission;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Iterator;
import java.util.List;

@Service
public class RolePermissionService {

    @Autowired
    private RolePermissionDao rolePermissionDao;

    public void changeRolePermission(List<Permission> haspermissions, String[] permissions, Integer roleid){
        int len_p=permissions.length;
        Iterator<Permission> it= haspermissions.iterator();
        while(it.hasNext()){
            Permission permission=it.next();
            int flag=0;
            for(int i=0;i<len_p;i++){
                if(Integer.valueOf(permissions[i])==permission.getId()){
                    flag=1;
                }
            }
            if(flag==0){//删除没有的
                rolePermissionDao.delete(new RolePermission(roleid,permission.getId()));
                System.out.println("删除："+roleid+"  "+permission.getId());
            }
        }

        for(int i=0;i<len_p;i++){
            int flag=0;
            it=haspermissions.iterator();
            while(it.hasNext()){
                if(it.next().getId()==Integer.valueOf(permissions[i])){
                    flag=1;
                }
            }
            if(flag==0){
                RolePermission rolePermission = new RolePermission(roleid, Integer.valueOf(permissions[i]));
                rolePermissionDao.insert(rolePermission);
                System.out.println("添加："+roleid+"  "+permissions[i]);
            }
        }
    }
}
