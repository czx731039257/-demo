package com.csx.demo2.dao;

import com.csx.demo2.entity.Message;
import com.csx.demo2.entity.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MessageDao {
    List<Message> test(User user);

    List<Message> select(Message message);

    List<Message> selectByUserName(String name);

    List<Message> selectGroup(User user);

    List<Message> selectOtherGroup(User user);

    void update(Message message);

    void insert(Message message);

    void deleteById(int id);
}
