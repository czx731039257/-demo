package com.csx.demo2.dao;

import com.csx.demo2.entity.Method;
import org.springframework.stereotype.Repository;

@Repository
public interface MethodDao {
    Method selectByUrl(String method_url);
}
