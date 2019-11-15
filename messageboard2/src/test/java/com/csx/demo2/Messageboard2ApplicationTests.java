package com.csx.demo2;

import com.csx.demo2.dao.MessageDao;
import com.csx.demo2.dao.UserDao;
import com.csx.demo2.entity.Message;
import com.csx.demo2.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.Iterator;
import java.util.List;

@MapperScan("com.csx.demo2.dao")
@RunWith(SpringRunner.class)
@SpringBootTest
public class Messageboard2ApplicationTests {

    @Autowired
    private UserDao userDao;

    @Autowired
    private MessageDao messageDao;

    @Test
    public void testSelectUser() {
        User user = new User();
        System.out.println(user);
        List<User> list = userDao.select(user);
        Iterator<User> it = list.iterator();
        while (it.hasNext()) {
            User next = it.next();

            System.out.println(next);
        }
    }

    @Test
    public void testUpdateUser() {
        User user = new User(4, "ss", "123123", "130130", "123132");
        userDao.update(user);
    }

    @Test
    public void testSelectMessage() {
        Message message = new Message();
        System.out.println(message);
        List<Message> list = messageDao.select(message);
        Iterator<Message> it = list.iterator();
        while (it.hasNext()) {
            Message next = it.next();
            System.out.println(next);
        }
    }

    @Test
    public void testUpdateMessage() {
        Message message = new Message(1, "zz", "zz", "2019-1-1 10:10:10", "2019-1-1 10:10:10", 1);
        messageDao.update(message);
    }

    @Test
    public void testInsertMessage() {
        Message message = new Message("aa", "zz", "2019-1-1 10:10:10", "2019-1-1 10:10:10", 1);
        messageDao.insert(message);
    }

    @Test
    public void testDeleteMessage() {
        messageDao.deleteById(87);
    }

    @Test
    public void testselectByUserName() {
        List<Message> list = messageDao.selectByUserName("张三");
        Iterator<Message> it = list.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }
    }

}
