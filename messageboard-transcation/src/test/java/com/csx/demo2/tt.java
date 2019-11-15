package com.csx.demo2;

import com.csx.demo2.entity.BillItem;
import com.csx.demo2.test.RedisTest;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class tt {

    @Autowired
    RedisTest redisTest;

    @Test
    public void aa() {

        long a = System.currentTimeMillis();
        List<BillItem> ss = redisTest.ss(4);
        long b = System.currentTimeMillis();

        ss.stream().forEach(System.out::print);
        System.out.println(b - a);
    }
}
