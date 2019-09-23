package com.demo.sis.dao;

import com.csx.demo2.entity.Page;
import com.demo.sis.entity.Student;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentDao {
    public List<Student> findpage(Page page);
    public List<Student> select(Student student);
    public void insert(Student student);
    public void deleteById(Integer id);
    public void update(Student student);

}
