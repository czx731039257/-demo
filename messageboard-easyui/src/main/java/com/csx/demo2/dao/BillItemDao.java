package com.csx.demo2.dao;

import com.csx.demo2.entity.BillItem;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BillItemDao {
    List<BillItem> selectBill(Integer userid);

    void insert(BillItem billItem);

    void deleteAllBillItem(Integer userid);
}
