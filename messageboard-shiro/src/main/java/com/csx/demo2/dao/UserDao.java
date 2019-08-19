package com.csx.demo2.dao;

import com.csx.demo2.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserDao {
     void update(User user);
     List<User> select(User user);
     List<User> selectOtherGroup(User user);
}
