package com.demo.sis.service;

import com.demo.sis.dao.StudentDao;
import com.demo.sis.entity.Page;
import com.demo.sis.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    private StudentDao studentDao;

    public Page findpage(Page page) {
        List<Student> students = studentDao.findpage(page);
        int total = studentDao.select(page.getStudent()).size();
        page.setRows(students);
        page.setTotal(total);
        return page;
    }

    public boolean insert(Student student) {
        int i = studentDao.insert(student);
        if (i != 0) {
            return true;
        } else {
            return false;
        }
    }

    public boolean update(Student student) {
        int i = studentDao.update(student);
        if (i != 0) {
            return true;
        } else {
            return false;
        }
    }

    public boolean deleteById(Integer id) {
        int i = studentDao.deleteById(id);
        if (i != 0) {
            return true;
        } else {
            return false;
        }
    }
}
