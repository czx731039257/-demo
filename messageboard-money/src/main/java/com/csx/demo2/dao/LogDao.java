package com.csx.demo2.dao;

import com.csx.demo2.entity.Log;
import com.csx.demo2.entity.Page;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LogDao {
    List<Log> selectByUserName(String user_name);
    List<Log> selectByUserId(Integer user_id);
    List<Log> selectAll();
    void deleteAllLog();
    void insert(Log log);
    List<Log> findpage(Page page);
    List<Log> select(Log Log);
}
