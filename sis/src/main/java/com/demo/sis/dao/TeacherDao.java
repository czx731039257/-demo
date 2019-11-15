package com.demo.sis.dao;

import com.demo.sis.entity.Page;
import com.demo.sis.entity.Teacher;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TeacherDao {
    public List<Teacher> findpage(Page page);

    public List<Teacher> select(Teacher teacher);

    public int insert(Teacher teacher);

    public int deleteById(Integer id);

    public int update(Teacher teacher);
}
