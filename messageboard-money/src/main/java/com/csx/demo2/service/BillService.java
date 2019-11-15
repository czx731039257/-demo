package com.csx.demo2.service;

import com.csx.demo2.dao.BillItemDao;
import com.csx.demo2.entity.BillItem;
import com.csx.demo2.entity.PageBean;
import com.csx.demo2.entity.Result;
import com.csx.demo2.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Service
public class BillService {
    @Autowired
    private BillItemDao billItemDao;

    public Result selectBill(Integer userid) {
        List<BillItem> bill = billItemDao.selectBill(userid);
        System.out.println(bill);
        PageBean pageBean = new PageBean(1, bill.size());
        Result result = new Result();
        result.setPageBean(pageBean);
        result.setBill(bill);
        return result;
    }

    public void emptyBill(Integer userid) {
        billItemDao.deleteAllBillItem(userid);
    }
}
