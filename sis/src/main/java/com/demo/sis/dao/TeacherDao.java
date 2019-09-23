package com.demo.sis.dao;

import com.csx.demo2.entity.Page;
import com.demo.sis.entity.Teacher;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TeacherDao {
    public List<Teacher> findpage(Page page);
    public List<Teacher> select(Teacher teacher);
    public void insert(Teacher teacher);
    public void deleteById(Integer id);
    public void update(Teacher teacher);
}
