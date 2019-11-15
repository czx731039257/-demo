package com.csx.demo2.service;

import com.csx.demo2.dao.HeadPortraitDao;
import com.csx.demo2.dao.UserDao;
import com.csx.demo2.entity.HeadPortrait;
import com.csx.demo2.entity.Result;
import com.csx.demo2.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HeadPortraitService {

    @Autowired
    private UserDao userDao;

    @Autowired
    private HeadPortraitDao headPortraitDao;

    public List<HeadPortrait> selectByUserId(Integer user_id) {
        return headPortraitDao.selectByUserId(user_id);
    }

    public Result insert(User user, HeadPortrait headPortrait) {
        headPortraitDao.insert(headPortrait);
        List<HeadPortrait> select = headPortraitDao.select(headPortrait);
        HeadPortrait headPortrait1 = select.get(0);
        user.setCurrentHeadPortrait(headPortrait1);
        user.setHeadportrait_id(headPortrait1.getId());
        userDao.update(user);
        List<HeadPortrait> headPortraits = headPortraitDao.selectByUserId(user.getId());
        user.setHeadPortraits(headPortraits);
        return new Result(user, null, null, null, "成功");
    }
}
