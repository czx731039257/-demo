package com.demo.sis.service;

import com.demo.sis.dao.StudentDao;
import com.demo.sis.dao.TeacherDao;
import com.demo.sis.entity.Page;
import com.demo.sis.entity.Student;
import com.demo.sis.entity.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherService {

    @Autowired
    private TeacherDao teacherDao;

    public Page findpage(Page page){
        List<Teacher> teachers = teacherDao.findpage(page);
        int total = teacherDao.select(page.getTeacher()).size();
        page.setRows(teachers);
        page.setTotal(total);
        return page;
    }

    public boolean insert(Teacher teacher){
        int i = teacherDao.insert(teacher);
        if(i!=0){
            return true;
        }else{
            return false;
        }
    }

    public boolean update(Teacher teacher){
        int i = teacherDao.update(teacher);
        if(i!=0){
            return true;
        }else{
            return false;
        }
    }

    public boolean deleteById(Integer id){
        int i = teacherDao.deleteById(id);
        if(i!=0){
            return true;
        }else{
            return false;
        }
    }
}
