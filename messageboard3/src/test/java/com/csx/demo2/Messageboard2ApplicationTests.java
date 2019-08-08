package com.csx.demo2;

import com.csx.demo2.dao.MessageDao;
import com.csx.demo2.dao.PermissionDao;
import com.csx.demo2.dao.UserDao;
import com.csx.demo2.entity.Group;
import com.csx.demo2.entity.Message;
import com.csx.demo2.entity.Permission;
import com.csx.demo2.entity.User;
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
    public void testSelectUser() {
        User user=new User();
        List<User> select = userDao.select(user);
        Iterator<User> it= select.iterator();
        while(it.hasNext()){
            System.out.println(it.next());
        }

    }
    @Test
    public void testUpdateUser() {
        User user=new User(1,"xx","xx","xx","xx",2);
        userDao.update(user);
    }

    @Test
    public void testSelectOtherGroupUser() {
        User user=new User();
        user.setGroup_id(1);
        List<User> select = userDao.selectOtherGroup(user);
        Iterator<User> it= select.iterator();
        while(it.hasNext()){
            System.out.println(it.next());
        }

    }

    @Test
    public void testSelectPermission() {
        List<Message> select = messageDao.select(new Message(null,null,null,null,null));
        Iterator<Message> it= select.iterator();
        while(it.hasNext()){
            System.out.println(it.next());
        }

    }

    @Test
    public void testuserrole() {
        List<User> users = userRoleService.selectAllUserAndRole();
        Iterator<User> it =users.iterator();
        while(it.hasNext()){
            System.out.println(it.next());
        }

    }

}
