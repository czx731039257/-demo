package com.csx.demo2.service;

import com.csx.demo2.dao.LogDao;
import com.csx.demo2.entity.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LogService {
    @Autowired
    private LogDao logDao;

    public List<Log> selectAll(){
        List<Log> logs = logDao.selectAll();
        return logs;
    }

    public List<Log> selectById(Integer user_id){
        List<Log> logs = logDao.selectByUserId(user_id);
        return logs;
    }

    public List<Log> selectByUserName(String username){
        List<Log> logs = logDao.selectByUserName(username);
        return logs;
    }

    public void insert(Log log){
        logDao.insert(log);
    }

    public void deleteAllLog(){
        logDao.deleteAllLog();
    }
}
