package com.csx.demo2.dao;

import com.csx.demo2.entity.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserDao {
     void update(User user);
     List<User> select(User user);
     List<User> selectOtherGroup(User user);
     User selectByMessageId(Integer id);
     void addMoney(User user);
     void miusMoney(User user);
}
