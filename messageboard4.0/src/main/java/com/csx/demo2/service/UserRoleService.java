package com.csx.demo2.service;

import com.csx.demo2.dao.UserDao;
import com.csx.demo2.dao.UserRoleDao;
import com.csx.demo2.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Iterator;
import java.util.List;

@Service
public class UserRoleService {

    @Autowired
    private UserRoleDao userRoleDao;

    @Autowired
    private UserDao userDao;

    /**
     * 查看所有的用户以及把他们具有的角色封装到用户对象中
     * @return
     */
    public List<User> selectAllUserAndRole(){
        List<User> users = userDao.select(new User(null, null, null, null, null, null));
        Iterator<User> it =users.iterator();
        while(it.hasNext()){
            User next = it.next();
            List<Role> roles =userRoleDao.select(next);
            next.setRoles(roles);
        }
        return users;
    }

    public void changeUserRole(Integer userid,String[] hasroles,List<Role> roles){
        int len_p=hasroles.length;
        Iterator<Role> it= roles.iterator();
        while(it.hasNext()){
            Role role=it.next();
            int flag=0;
            for(int i=0;i<len_p;i++){
                if(Integer.valueOf(hasroles[i])==role.getId()){
                    flag=1;
                }
            }
            if(flag==0){//删除没有的
                userRoleDao.delete(new UserRole(userid,role.getId()));
                System.out.println("删除："+userid+"---"+role.getId());
            }
        }

        for(int i=0;i<len_p;i++){
            int flag=0;
            it=roles.iterator();
            while(it.hasNext()){
                if(it.next().getId()==Integer.valueOf(hasroles[i])){
                    flag=1;
                }
            }
            if(flag==0){
                userRoleDao.insert(new UserRole(userid,Integer.valueOf(hasroles[i])));
                System.out.println("添加："+userid+"--"+hasroles[i]);
            }
        }
    }
}
