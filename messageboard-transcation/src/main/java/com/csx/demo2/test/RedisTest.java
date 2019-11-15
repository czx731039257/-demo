package com.csx.demo2.test;

import com.csx.demo2.dao.BillItemDao;
import com.csx.demo2.dao.MessageDao;
import com.csx.demo2.entity.BillItem;
import com.csx.demo2.entity.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RedisTest {

    @Autowired
    BillItemDao billItemDao;

    @Cacheable(value = "rediscache")
    public List<BillItem> ss(int userid) {
        List<BillItem> billItems = billItemDao.selectBill(userid);
        System.out.println("查询数据库");
        return billItems;
    }

}
