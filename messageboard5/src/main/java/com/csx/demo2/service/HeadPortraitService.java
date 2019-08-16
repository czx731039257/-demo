package com.csx.demo2.service;

import com.csx.demo2.dao.HeadPortraitDao;
import com.csx.demo2.entity.HeadPortrait;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HeadPortraitService {

    @Autowired
    private HeadPortraitDao headPortraitDao;

    public List<HeadPortrait> selectByUserId(Integer user_id){
        return headPortraitDao.selectByUserId(user_id);
    }

    public void insert(HeadPortrait headPortrait){
        headPortraitDao.insert(headPortrait);
    }
}
