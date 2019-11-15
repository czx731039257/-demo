package com.csx.dao;

import org.springframework.stereotype.Repository;

@Repository
public interface UserDao {
    String selectByUserName(String username);
}
