package com.csx.demo2.dao;

import com.csx.demo2.entity.Page;
import com.csx.demo2.entity.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserDao {
    List<User> select(User user);

    List<User> findpage(Page page);

    int update(User user);
}
