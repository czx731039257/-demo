package com.demo.sis.dao;

import com.demo.sis.entity.Class;
import com.demo.sis.entity.Page;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClassDao {
    public List<Class> findpage(Page page);
    public List<Class> select(Class c);
    public int insert(Class c);
    public int deleteById(Integer id);
    public int update(Class c);
}
