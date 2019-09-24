package com.demo.sis.dao;

import com.demo.sis.entity.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserDao {
    public List<User> select(User user);

}
