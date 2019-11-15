package com.csx.demo2.service;

import com.csx.demo2.dao.BillItemDao;
import com.csx.demo2.dao.HeadPortraitDao;
import com.csx.demo2.dao.MessageDao;
import com.csx.demo2.dao.UserDao;
import com.csx.demo2.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

@Service
public class UserService {

    @Resource(name = "userDao")
    private UserDao userDao;

    @Autowired
    private MessageDao messageDao;

    @Autowired
    private HeadPortraitDao headPortraitDao;

    @Autowired
    private BillItemDao billItemDao;

    /*
     * 查询所有用户的基本信息和留言数
     * @return 返回用户信息集合
     * */
    public List<User> selectAllUserInfo() {
        List<User> users = userDao.select(new User.Builder().build());
        Iterator<User> it = users.iterator();
        while (it.hasNext()) {
            User next = it.next();
            //System.out.println(next.getId());
            List<Message> messages = messageDao.select(new Message.Builder().user_id(next.getId()).build());
            next.setCount_message(messages.size());
        }
        return users;
    }

    public List<User> selectGroupUserInfo(User user) {
        Integer group_id = userDao.select(user).get(0).getGroup_id();
        List<User> users = userDao.select(new User.Builder().group_id(group_id).build());
        Iterator<User> it = users.iterator();
        while (it.hasNext()) {
            User next = it.next();
            //System.out.println(next.getId());
            List<Message> messages = messageDao.select(new Message.Builder().user_id(next.getId()).build());
            next.setCount_message(messages.size());
        }
        return users;
    }

    public List<User> selectOtherGroupUserInfo(User user) {
        List<User> users = userDao.selectOtherGroup(new User.Builder().group_id(user.getGroup_id()).build());
        Iterator<User> it = users.iterator();
        while (it.hasNext()) {
            User next = it.next();
            //System.out.println(next.getId());
            List<Message> messages = messageDao.select(new Message.Builder().user_id(next.getId()).build());
            next.setCount_message(messages.size());
        }
        return users;
    }

    /*
     * 查询个人信息
     * @return 返回个人用户对象
     * */
    public User selectPersonInfo(User user) {
        user = userDao.select(new User.Builder().id(user.getId()).build()).get(0);
        List<Message> messages = messageDao.select(new Message.Builder().user_id(user.getId()).build());
        user.setCount_message(messages.size());
        List<HeadPortrait> headPortraits = headPortraitDao.selectByUserId(user.getId());//用户的头像仓库
        user.setHeadPortraits(headPortraits);
        if (user.getHeadportrait_id() == 0) {
            user.setCurrentHeadPortrait(new HeadPortrait(null, null, "userhead/18aece051dd6a1807abf05eab596fed5.jpg"));
        } else {
            List<HeadPortrait> select = headPortraitDao.select(new HeadPortrait(user.getHeadportrait_id(), null, null));
            HeadPortrait headPortrait = select.get(0);
            user.setCurrentHeadPortrait(headPortrait);
        }
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
    public User editPersonInfo(User user, String name, String password, String email, String phone) {
        user.setName(name);
        user.setEmail(email);
        user.setPassword(password);
        user.setPhone(phone);
        //System.out.println(user);
        userDao.update(user);
        return user;
    }

    public User editPersonHead(User user, Integer headportrait_id) {
        user.setHeadportrait_id(headportrait_id);
        HeadPortrait headPortrait = headPortraitDao.select(new HeadPortrait(headportrait_id, null, null)).get(0);
        user.setCurrentHeadPortrait(headPortrait);
        userDao.update(user);
        return user;
    }

    public User editUserInfo(String userid) {
        User user = userDao.select(new User.Builder().id(Integer.valueOf(userid)).build()).get(0);
        List<HeadPortrait> headPortraits = headPortraitDao.selectByUserId(user.getId());//用户的头像仓库
        user.setHeadPortraits(headPortraits);
        List<HeadPortrait> select = headPortraitDao.select(new HeadPortrait(user.getHeadportrait_id(), null, null));
        HeadPortrait headPortrait = select.get(0);
        user.setCurrentHeadPortrait(headPortrait);
        return user;
    }

    public List<User> editUserInfoSuccess(List<User> users, String id, String name, String password, String email, String phone, String group_id) {
        userDao.update(new User.Builder().id(Integer.valueOf(id)).name(name).password(password).email(email).phone(phone).group_id(Integer.valueOf(group_id)).build());
        Iterator<User> it = users.iterator();
        while (it.hasNext()) {
            User next = it.next();
            if (next.getId().equals(Integer.valueOf(id))) {
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

    /**
     * 充值操作的业务逻辑
     *
     * @param
     * @param money
     */
    public Result recharge(User user, Double money) {
        user.setMoney(money);
        userDao.addMoney(user);
        user = userDao.select(new User.Builder().id(user.getId()).build()).get(0);
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String formatDate = simpleDateFormat.format(date);
        billItemDao.insert(new BillItem(null, "充值", money, user.getId(), formatDate));
        return new Result.Builder().user(user).build();
    }

    @Transactional()
    public Double reward(HttpSession session, Integer addUserId, User user, Double money) throws RuntimeException {
        userDao.miusMoney(new User.Builder().id(user.getId()).money(money).build());
        if ((int) (Math.random() * 100) < 49) {
            throw new RuntimeException();
        }
        userDao.addMoney(new User.Builder().id(addUserId).money(money).build());
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String formatDate = simpleDateFormat.format(date);
        billItemDao.insert(new BillItem(null, "消费", money, user.getId(), formatDate));
        billItemDao.insert(new BillItem(null, "收到打赏", money, addUserId, formatDate));
        User adduser = userDao.select(new User.Builder().id(addUserId).build()).get(0);
        User minususer = userDao.select(new User.Builder().id(user.getId()).build()).get(0);

        session.setAttribute("user", minususer);
        List<Message> messages = (List<Message>) session.getAttribute("messageSet");
        Iterator<Message> it = messages.iterator();
        while (it.hasNext()) {
            Message next = it.next();
            if (next.getUser_id() == addUserId) {
                next.setUser(adduser);
            }
        }

        return minususer.getMoney();
    }

    public Page findpage(Integer page, Integer nrow, Integer userid, Integer groupid) {
        Page pagebean = new Page();
        pagebean.setPageNumber(page);
        pagebean.setPageSize(nrow);
        pagebean.setStartIndex((page - 1) * nrow);
        pagebean.setUser(new User.Builder().id(userid).group_id(groupid).build());

        List<User> findpage = userDao.findpage(pagebean);
        Integer total = userDao.select(new User.Builder().id(userid).group_id(groupid).build()).size();
        pagebean.setTotal(total);
        pagebean.setRows(findpage);
        return pagebean;
    }
}
