package com.csx.demo2.service;

import com.csx.demo2.dao.MessageDao;
import com.csx.demo2.entity.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageService {

    @Autowired
    private MessageDao messageDao;

    public List<Message> selectAllMessage() {
        List<Message> messages = messageDao.select(new Message(0, null, null, null, null, 0));
        return messages;
    }

}
