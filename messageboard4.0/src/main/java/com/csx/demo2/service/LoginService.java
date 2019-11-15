package com.csx.demo2.service;

import com.csx.demo2.dao.MessageDao;
import com.csx.demo2.dao.PermissionDao;
import com.csx.demo2.dao.UserDao;
import com.csx.demo2.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.Iterator;
import java.util.List;

@Service
public class LoginService {

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
    public VerifyResult loginverify(String username, String password) {
//        List<User> check = userDao.select(new User(null,username,password,null,null,null));//根据用户名和密码查看该用户
//
//        if(check.size()==1){//登入成功
//            User user = check.get(0);//获取当前用户的基本信息
//            List<Message> messages = messageDao.selectByUserName(user);//查询当前用户的所有个人留言集合
//            int totalRecord=messages.size();//总留言数
//            PageBean pageBean=new PageBean(1,totalRecord);//根据留言集合封装 分页对象
//            pageBean.setMessagesType(1);//个人留言
//            List<Permission> permissions = permissionDao.select(user);//查看当前用户的权限集合
//            return new Result(user,true,pageBean,messages,permissions);
//        }else{//登入失败
//            //System.out.println("登入失败！");
//            return new Result(false,null,null,null);
//        }

        List<User> check = userDao.select(new User(null, username, null, null, null, null));//根据用户名和密码查看该用户

        if (check.size() == 1) {//有该用户
            User user = check.get(0);//获取当前用户的基本信息
            if (user.getPassword().equals(password)) {
                List<Message> messages = messageDao.selectByUserName(user);//查询当前用户的所有个人留言集合
                int totalRecord = messages.size();//总留言数
                PageBean pageBean = new PageBean(1, totalRecord);//根据留言集合封装 分页对象
                pageBean.setMessagesType(1);//个人留言
                List<Permission> permissions = permissionDao.select(user);//查看当前用户的权限集合
                //return new Result(user, true, pageBean, messages, permissions);
                return new VerifyResult(user, 2, pageBean, messages, permissions, "成功");
            } else {
                return new VerifyResult(user, 1, null, null, null, "失败");
            }
        } else {//没有该用户
            return new VerifyResult(null, 0, null, null, null, "失败");
        }

    }
}
