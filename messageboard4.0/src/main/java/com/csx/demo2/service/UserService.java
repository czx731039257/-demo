package com.csx.demo2.service;

import com.csx.demo2.dao.MessageDao;
import com.csx.demo2.dao.UserDao;
import com.csx.demo2.entity.Group;
import com.csx.demo2.entity.Message;
import com.csx.demo2.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Iterator;
import java.util.List;

@Service
public class UserService {

    @Resource(name="userDao")
    private UserDao userDao;

    @Autowired
    private MessageDao messageDao;

    /*
    * 查询所有用户的基本信息和留言数
    * @return 返回用户信息集合
    * */
    public List<User> selectAllUserInfo(){
        List<User> users = userDao.select(new User());
        Iterator<User> it=users.iterator();
        while(it.hasNext()){
            User next = it.next();
            //System.out.println(next.getId());
            List<Message> messages = messageDao.select(new Message(null,null,null,null,next.getId()));
            next.setCount_message(messages.size());
        }
        return users;
    }

    public List<User> selectGroupUserInfo(User user){
        Integer group_id = userDao.select(user).get(0).getGroup_id();
        List<User> users = userDao.select(new User(null,null,null,null,null,group_id));
        Iterator<User> it=users.iterator();
        while(it.hasNext()){
            User next = it.next();
            //System.out.println(next.getId());
            List<Message> messages = messageDao.select(new Message(null,null,null,null,next.getId()));
            next.setCount_message(messages.size());
        }
        return users;
    }

    public List<User> selectOtherGroupUserInfo(User user){
        List<User> users = userDao.selectOtherGroup(new User(null,null,null,null,null,user.getGroup_id()));
        Iterator<User> it=users.iterator();
        while(it.hasNext()){
            User next = it.next();
            //System.out.println(next.getId());
            List<Message> messages = messageDao.select(new Message(null,null,null,null,next.getId()));
            next.setCount_message(messages.size());
        }
        return users;
    }

    /*
    * 查询个人信息
    * @return 返回个人用户对象
    * */
    public User selectPersonInfo(User user){
        user = userDao.select(new User(user.getId(), null, null, null, null, null)).get(0);
        List<Message> messages = messageDao.select(new Message(null,null,null,null,user.getId()));
        user.setCount_message(messages.size());
        return user;
    }

    /*
    * 修改个人信息
    * @param user 个人用户对象
    * @param id 个人用户id
    * @param name 修改后的个人用户名
    * @param password 修改后的个人密码
    * @param email 修改后的个人邮箱
    * @param phone 修改后的个人手机号
    * @return 返回修改后的个人用户对象
    * */
    public User editPersonInfo(User user,String name,String password,String email,String phone){
        user.setName(name);
        user.setEmail(email);
        user.setPassword(password);
        user.setPhone(phone);
        //System.out.println(user);
        userDao.update(user);
        return user;
    }

    public User editUserInfo(String userid){
        User user = userDao.select(new User(Integer.valueOf(userid), null, null, null, null, null)).get(0);
        return user;
    }

    public List<User> editUserInfoSuccess(List<User> users, String id, String name, String password, String email, String phone, String group_id){
        userDao.update(new User(Integer.valueOf(id), name, password, email, phone, Integer.valueOf(group_id)));
        Iterator<User> it=users.iterator();
        while(it.hasNext()){
            User next=it.next();
            if(next.getId().equals(Integer.valueOf(id))){
                next.setName(name);
                next.setPassword(password);
                next.setEmail(email);
                next.setPhone(phone);
                next.setGroup_id(Integer.valueOf(group_id));
                break;
            }
        }
        return users;
    }
}
