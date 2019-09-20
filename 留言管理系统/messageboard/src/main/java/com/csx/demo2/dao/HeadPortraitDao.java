package com.csx.demo2.dao;

import com.csx.demo2.entity.HeadPortrait;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HeadPortraitDao {

   List<HeadPortrait> select(HeadPortrait headPortrait);
   List<HeadPortrait> selectByUserId(Integer user_id);
   void insert(HeadPortrait headPortrait);
}
