package com.csx.demo2.service;

import com.csx.demo2.dao.UserDao;
import com.csx.demo2.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Iterator;
import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserDao userDao;

    public Page findpage(Page page){
        List<User> users = userDao.findpage(page);
        Integer total = userDao.select(page.getUser()).size();
        page.setTotal(total);
        page.setRows(users);
        return page;
    }

    public boolean update(User user){
        int i = userDao.update(user);
        if(i!=0){
            return true;
        }else{
            return false;
        }
    }
}
