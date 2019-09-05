package com.csx.demo2;

import com.csx.demo2.dao.MessageDao;
import com.csx.demo2.dao.UserDao;
import com.csx.demo2.entity.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@MapperScan("com.csx.demo2.dao")
@RunWith(SpringRunner.class)
@SpringBootTest
public class Messageboard2ApplicationTests {

    @Autowired
    private MessageDao messageDao;

    @Test
    public void test(){
//        int insert = messageDao.insert(new Message.Builder().label("ttttt").detail("iiiii").date_edit("2017-1-1 01:01:01").date_create("2017-1-1 01:01:01").user_id(1).build());
//        System.out.println(insert);
    }
}
