package com.csx.demo2.service;

import com.csx.demo2.dao.MessageDao;
import com.csx.demo2.dao.UserDao;
import com.csx.demo2.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class MessageService {

    @Autowired
    private MessageDao messageDao;

    @Autowired
    private UserDao userDao;

    /**
     * 分页查询
     * @param page
     * @return
     */
    public Page findpage(Page page){
        List<Message> messages = messageDao.findpage(page);
        int total = messageDao.select(page.getMessage()).size();
        page.setRows(messages);
        page.setTotal(total);
        return page;
    }

    /**
     * 新建留言
     * @param message
     * @return
     */
    public boolean insert(Message message){
        int i = messageDao.insert(message);
        if(i!=0){
            return true;
        }else{
            return false;
        }
    }

    /**
     * 编辑留言
     * @param message
     * @return
     */
    public boolean update(Message message){
        int i = messageDao.update(message);
        if(i!=0){
            return true;
        }else{
            return false;
        }
    }

    /**
     * 根据id删除留言
     * @param messageid 留言id
     * @return
     */
    public boolean deleteById(Integer messageid){
        int i = messageDao.deleteById(messageid);
        if(i!=0){
            return true;
        }else{
            return false;
        }
    }
}
