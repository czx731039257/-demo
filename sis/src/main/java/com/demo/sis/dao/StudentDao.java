package com.demo.sis.dao;

import com.demo.sis.entity.Page;
import com.demo.sis.entity.Student;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentDao {
    public List<Student> findpage(Page page);
    public List<Student> select(Student student);
    public int insert(Student student);
    public int deleteById(Integer id);
    public int update(Student student);

}
