package com.demo.sis.dao;

import com.demo.sis.entity.Course;
import com.demo.sis.entity.Page;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseDao {
    public List<Course> findpage(Page page);

    public List<Course> select(Course course);

    public int insert(Course course);

    public int deleteById(Integer id);

    public int update(Course course);
}
