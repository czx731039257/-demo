package com.csx.demo2.dao;

import com.csx.demo2.entity.Message;
import com.csx.demo2.entity.Page;
import com.csx.demo2.entity.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MessageDao {
    List<Message> findpage(Page page);

    List<Message> select(Message message);

    int insert(Message message);

    int update(Message message);

    int deleteById(Integer messageid);
}
