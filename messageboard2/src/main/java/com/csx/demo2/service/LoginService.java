package com.csx.demo2.service;

import com.csx.demo2.dao.MessageDao;
import com.csx.demo2.dao.UserDao;
import com.csx.demo2.entity.Message;
import com.csx.demo2.entity.PageBean;
import com.csx.demo2.entity.User;
import com.csx.demo2.entity.VerifyResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Iterator;
import java.util.List;

@Service
public class LoginService {
    @Autowired
    private UserDao userDao;

    @Autowired
    private MessageDao messageDao;

    public VerifyResult loginverify(String username, String password) {
        List<User> check = userDao.select(new User(0, username, password, null, null));//根据用户名和密码查看该用户

        if (check.size() == 1) {//登入成功
            User user = null;
            System.out.println("登入成功！");
            Iterator<User> it = check.iterator();
            while (it.hasNext()) {//获取用户对象
                user = it.next();
            }
            List<Message> messageSet = messageDao.select(new Message());
            int totalRecord = messageSet.size();
            PageBean pageBean = new PageBean(1, 10, totalRecord);
            return new VerifyResult(true, user, pageBean);
        } else {//登入失败
            System.out.println("登入失败！");
            //session.setAttribute("error","用户或者密码错误！");
            return new VerifyResult(false, null, null);
        }
    }
}
