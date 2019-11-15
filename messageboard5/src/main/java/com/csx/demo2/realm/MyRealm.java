package com.csx.demo2.realm;

import com.csx.demo2.dao.PermissionDao;
import com.csx.demo2.dao.UserDao;
import com.csx.demo2.entity.User;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MyRealm extends AuthorizingRealm {

    @Autowired
    private UserDao userDao;

    @Autowired
    private PermissionDao permissionDao;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        // String primaryPrincipal = (String)principalCollection.getPrimaryPrincipal();
        //System.out.println("用户名："+primaryPrincipal);
        info.addStringPermission("select");
        Set<String> set = new HashSet<>();
        set.add("role1");
        info.setRoles(set);
        return info;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
        String username = token.getUsername();
        List<User> users = userDao.select(new User(null, username, null, null, null, null));
        SimpleAuthenticationInfo info = null;
        if (users.size() == 0) {
            throw new AuthenticationException();
        } else {
            User user = users.get(0);
            String password = user.getPassword();
            info = new SimpleAuthenticationInfo(username, password, this.getName());
        }
        return info;
    }
}
