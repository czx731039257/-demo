package com.csx.demo2.service;

import com.csx.demo2.dao.LogDao;
import com.csx.demo2.entity.Log;
import com.csx.demo2.entity.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LogService {

    @Autowired
    private LogDao logDao;


    /**
     * 分页查询日志
     * @param page
     * @return
     */
    public Page findpage(Page page){
        List<Log> logs = logDao.findpage(page);
        int total = logDao.select(page.getLog()).size();
        page.setRows(logs);
        page.setTotal(total);
        return page;
    }

    /**
     * 清空日志
     * @return 返回true表示清空成功；返回false表示清空失败
     */
    public boolean emptyLogs(){
        int i = logDao.deleteAll();
        List<Log> logs = logDao.select(new Log.Builder().build());
        if(logs.size()==0){
            return true;
        }else{
            return false;
        }
    }
}
