package com.demo.sis.dao;

import com.demo.sis.entity.Course;
import com.csx.demo2.entity.Page;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseDao {
    public List<Course> findpage(Page page);
    public List<Course> select(Course course);
    public void insert(Course course);
    public void deleteById(Integer id);
    public void update(Course course);
}
