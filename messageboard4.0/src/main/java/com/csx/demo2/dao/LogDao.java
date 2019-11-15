package com.csx.demo2.dao;

import com.csx.demo2.entity.Log;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LogDao {
    /**
     * @param user_name：
     * @return
     */
    List<Log> selectByUserName(String user_name);

    List<Log> selectByUserId(Integer user_id);

    List<Log> selectAll();

    void deleteAllLog();

    void insert(Log log);
}
