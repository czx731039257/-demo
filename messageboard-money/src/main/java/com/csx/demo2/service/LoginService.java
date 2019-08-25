package com.csx.demo2.service;

import com.csx.demo2.dao.HeadPortraitDao;
import com.csx.demo2.dao.MessageDao;
import com.csx.demo2.dao.PermissionDao;
import com.csx.demo2.dao.UserDao;
import com.csx.demo2.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoginService {

    @Autowired
    private UserDao userDao;

    @Autowired
    private MessageDao messageDao;

    @Autowired
    private PermissionDao permissionDao;

    @Autowired
    private HeadPortraitDao headPortraitDao;

    /*
     * 登入验证业务逻辑
     * @param username 验证的用户名
     * @param password 验证的密码
     * @return 返回验证结果
     * */
    public Result getUserInfo(String username) {
        List<User> check = userDao.select(new User.Builder().name(username).build());//根据用户名和密码查看该用户
        User user = check.get(0);//获取当前用户的基本信息
        List<Message> messages = messageDao.selectByUserName(user);//查询当前用户的所有个人留言集合
        int totalRecord = messages.size();//总留言数
        PageBean pageBean = new PageBean(1, totalRecord);//根据留言集合封装 分页对象
        pageBean.setMessagesType(1);//个人留言
        List<Permission> permissions = permissionDao.select(user);//查看当前用户的权限集合
        //return new Result(user, true, pageBean, messages, permissions);
        List<HeadPortrait> headPortraits = headPortraitDao.selectByUserId(user.getId());//用户的头像仓库
        user.setHeadPortraits(headPortraits);
        if(user.getHeadportrait_id()==0){
            user.setCurrentHeadPortrait(new HeadPortrait(null,null,"userhead/18aece051dd6a1807abf05eab596fed5.jpg"));
        }else{
            List<HeadPortrait> select = headPortraitDao.select(new HeadPortrait(user.getHeadportrait_id(), null, null));
            HeadPortrait headPortrait = select.get(0);
            user.setCurrentHeadPortrait(headPortrait);
        }
        return new Result(user, pageBean, messages, permissions,"成功",null);
    }
}
