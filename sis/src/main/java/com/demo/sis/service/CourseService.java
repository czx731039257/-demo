package com.demo.sis.service;

import com.demo.sis.dao.CourseDao;
import com.demo.sis.dao.StudentDao;
import com.demo.sis.entity.Course;
import com.demo.sis.entity.Page;
import com.demo.sis.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService {

    @Autowired
    private CourseDao courseDao;

    public Page findpage(Page page){
        List<Course> courses = courseDao.findpage(page);
        int total = courseDao.select(page.getCourse()).size();
        page.setRows(courses);
        page.setTotal(total);
        return page;
    }

    public boolean insert(Course course){
        int i = courseDao.insert(course);
        if(i!=0){
            return true;
        }else{
            return false;
        }
    }

    public boolean update(Course course){
        int i = courseDao.update(course);
        if(i!=0){
            return true;
        }else{
            return false;
        }
    }

    public boolean deleteById(Integer id){
        int i = courseDao.deleteById(id);
        if(i!=0){
            return true;
        }else{
            return false;
        }
    }
}
