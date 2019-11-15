package com.demo.serviceimpl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.demo.dao.StudentDao;
import com.demo.entity.Student;
import com.demo.service.StudentService;

@Service("studentService")
public class StudentServiceImpl implements StudentService {


    @Resource(name = "studentDao")
    private StudentDao studentdao;

    @Override
    public List<Student> queryStudent(Student student) {
        // TODO Auto-generated method stub
        List<Student> list = studentdao.queryStudent(student);

        return list;
    }


    @Override
    public void deleteStudentBySno(String sno) {
        // TODO Auto-generated method stub
        studentdao.deleteStudentBySno(sno);
    }

    @Override
    public void insertStudent(Student student) {
        // TODO Auto-generated method stub
        studentdao.insertStudent(student);
    }

    @Override
    public void updatestudentBySno(Student student) {
        // TODO Auto-generated method stub
        studentdao.updatestudentBySno(student);
    }


    @Override
    public List<Student> queryAllStudent() {
        // TODO Auto-generated method stub
        List<Student> list = studentdao.queryAllStudent();
        return list;
    }


}
