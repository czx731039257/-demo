package com.csx.demo2.dao;

import com.csx.demo2.entity.Log;
import com.csx.demo2.entity.Page;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LogDao {
    List<Log> findpage(Page page);

    List<Log> select(Log Log);

    int deleteAll();
}
