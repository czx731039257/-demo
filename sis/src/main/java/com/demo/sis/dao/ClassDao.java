package com.demo.sis.dao;

import com.demo.sis.entity.Class;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClassDao {
    public List<Class> findpage(Page page);
    public List<Class> select(Class c);
    public void insert(Class c);
    public void deleteById(Integer id);
    public void update(Class c);
}
