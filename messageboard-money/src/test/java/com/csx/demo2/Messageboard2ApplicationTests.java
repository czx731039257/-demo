package com.csx.demo2;

import com.csx.demo2.dao.MessageDao;
import com.csx.demo2.dao.PermissionDao;
import com.csx.demo2.dao.UserDao;
import com.csx.demo2.entity.*;
import com.csx.demo2.service.UserRoleService;
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

    @Autowired
    private PermissionDao permissionDao;

    @Autowired
    private UserRoleService userRoleService;


    @Test
    public void xxx() {

    }

}
