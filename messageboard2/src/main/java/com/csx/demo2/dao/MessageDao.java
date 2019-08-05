package com.csx.demo2.dao;

import com.csx.demo2.entity.Message;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MessageDao {
    List<Message> select(Message message);
    List<Message> selectByUserName(String name);
    void update(Message message);
    void insert(Message message);
    void deleteById(int id);
}
