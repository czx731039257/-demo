package com.demo.sis.realm;


import com.demo.sis.dao.UserDao;
import com.demo.sis.entity.User;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Iterator;
import java.util.List;

public class MyRealm extends AuthorizingRealm {
    @Autowired
    private UserDao userDao;

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
        String username = token.getUsername();
        List<User> users = userDao.select(new User.Builder().username(username).build());
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
        return null;
    }
}
