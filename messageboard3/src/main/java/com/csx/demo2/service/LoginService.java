package com.csx.demo2.service;

import com.csx.demo2.dao.MessageDao;
import com.csx.demo2.dao.PermissionDao;
import com.csx.demo2.dao.UserDao;
import com.csx.demo2.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Iterator;
import java.util.List;

@Service
public class LoginService  {
    @Autowired
    private UserDao userDao;

    @Autowired
    private MessageDao messageDao;

    @Autowired
    private PermissionDao permissionDao;
    /*
    * 登入验证业务逻辑
    * @param username 验证的用户名
    * @param password 验证的密码
    * @return 返回验证结果
    * */
    public Result loginverify(String username, String password){
        List<User> check = userDao.select(new User(null,username,password,null,null,null));//根据用户名和密码查看该用户

        if(check.size()==1){//登入成功
            System.out.println("登入成功！");
            User user = check.get(0);
            List<Message> messages = messageDao.selectByUserName(username);
            int totalRecord=messages.size();
            System.out.println("total:"+totalRecord);
            PageBean pageBean=new PageBean(1,totalRecord);
            pageBean.setMessagesType(1);//个人留言
            List<Permission> permissions = permissionDao.select(user);
            Iterator<Permission> it= permissions.iterator();
            System.out.println("权限表：");
            while(it.hasNext()){
                System.out.println(it.next());
            }
            return new Result(user,true,pageBean,messages,permissions);
        }else{//登入失败
            System.out.println("登入失败！");
            //session.setAttribute("error","用户或者密码错误！");
            return new Result(false,null,null,null);
        }
    }
}
