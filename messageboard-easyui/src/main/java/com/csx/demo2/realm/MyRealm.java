package com.csx.demo2.realm;

import com.csx.demo2.dao.PermissionDao;
import com.csx.demo2.dao.RoleDao;
import com.csx.demo2.dao.UserDao;
import com.csx.demo2.entity.Permission;
import com.csx.demo2.entity.Role;
import com.csx.demo2.entity.User;
import lombok.Data;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class MyRealm extends AuthorizingRealm {

    @Autowired
    private UserDao userDao;

    @Autowired
    private RoleDao roleDao;

    @Autowired
    private PermissionDao permissionDao;

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
        String username = token.getUsername();
        User build = new User.Builder().name(username).build();
        List<User> users = userDao.select(new User.Builder().name(username).build());
        SimpleAuthenticationInfo info=null;
        if(users.size()==0){
            throw new AuthenticationException();
        }else{
            User user = users.get(0);
            String password = user.getPassword();
            info =new SimpleAuthenticationInfo(username,password,this.getName());
        }
        return info;
    }

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        SimpleAuthorizationInfo info=new SimpleAuthorizationInfo();
        String username = (String)principalCollection.getPrimaryPrincipal();
        List<Permission> permissions = permissionDao.selectByUserName(username);
        Iterator<Permission> it=permissions.iterator();
        while(it.hasNext()){
            info.addStringPermission(it.next().getName());
        }
        //从数据库中查询并添加角色
        List<Role> roles = roleDao.selectByUserName(username);
        Iterator<Role> it2=roles.iterator();
        while(it2.hasNext()){
            info.addRole(it2.next().getName());
        }
        return info;
    }
}
