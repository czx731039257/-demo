package com.demo.controller;

import java.io.IOException;
import java.io.Reader;
import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.demo.entity.Student;
import com.demo.service.StudentService;
import com.demo.serviceimpl.StudentServiceImpl;

@RequestMapping("student")
@Controller
public class studentcontroller {

    @Resource(name = "studentService")
    private StudentService studentservice;

    @RequestMapping("queryStudentBySno")
    public String queryStudent(Student student, Model model) {
        List<Student> list = studentservice.queryStudent(student);

        model.addAttribute("student", list);

        /* �����������ڿ���̨��ʾ���ݵ�*/
        Iterator<Student> it = list.iterator();
        while (it.hasNext()) {
            Student str = it.next();
            System.out.println("����:" + str.getName() + " ѧ��:" + str.getSno() + " �Ա�:" + str.getSex() + " ����:" + str.getAge() + " רҵ:" + str.getMajor());
        }

        return "success";
    }


    @RequestMapping("deleteStudentBySno")
    public String deleteStudentBySno(@RequestParam("sno") String sno, Model model) {
        studentservice.deleteStudentBySno(sno);
        Student student = new Student();
        student.setSno(sno);
        List<Student> list = studentservice.queryStudent(student);
        if (list.size() == 0) {
            model.addAttribute("deleteResult", "true");
            return "success";
        } else {
            model.addAttribute("deleteResult", "true");
            return "success";
        }
    }

    @RequestMapping("insertStudent")
    public String insertStudent(Student student, Model model) {
        studentservice.insertStudent(student);
        List<Student> list = studentservice.queryStudent(student);
        Iterator<Student> it = list.iterator();
        while (it.hasNext()) {
            if (it.next().equals(student)) {
                model.addAttribute("insertResult", "success");
                list = studentservice.queryAllStudent();
                model.addAttribute("student", list);
                return "success";
            }
        }
        model.addAttribute("insertResult", "false");
        return "success";
    }

    @RequestMapping("updatestudentBySno")
    public String updatestudentBySno(Student student, Model model) {
        studentservice.updatestudentBySno(student);
        List<Student> list = studentservice.queryStudent(student);
        Iterator<Student> it = list.iterator();
        while (it.hasNext()) {
            if (it.next().equals(student)) {
                model.addAttribute("updateResult", "success");
                list = studentservice.queryAllStudent();
                model.addAttribute("student", list);
                return "success";
            }
        }
        model.addAttribute("updateResult", "false");
        return "success";
    }
}
