package com.demo.sis.controller;

import com.demo.sis.entity.Page;
import com.demo.sis.entity.Result;
import com.demo.sis.entity.StringUtils;
import com.demo.sis.entity.Student;
import com.demo.sis.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@Controller
public class StudentAction {

    @Autowired
    private StudentService studentService;

    @ResponseBody
    @RequestMapping("/queryAllStudent")
    public Page queryAllStudent(HttpServletRequest req) throws IOException {
        Integer pageNumber = Integer.valueOf(req.getParameter("page"));
        Integer pageSize = Integer.valueOf(req.getParameter("rows"));
        String id = req.getParameter("id");
        String name = req.getParameter("name");
        String major = req.getParameter("major");
        String class_id = req.getParameter("class_id");
        Page page = new Page.Builder().pageNumber(pageNumber).pageSize(pageSize).startIndex((pageNumber - 1) * pageSize).build();

        Student student = new Student();
        if (StringUtils.isNoBlank(id)) {
            student.setId(Integer.valueOf(id));
            page.setStudent(student);
        }
        if (StringUtils.isNoBlank(name)) {
            student.setName(name);
            page.setStudent(student);
        }
        if (StringUtils.isNoBlank(major)) {
            student.setMajor(major);
            page.setStudent(student);
        }
        if (StringUtils.isNoBlank(class_id)) {
            student.setClass_id(Integer.valueOf(class_id));
            page.setStudent(student);
        }
        page = studentService.findpage(page);
        return page;
    }


    @ResponseBody
    @RequestMapping("/insertStudent")
    public Result insertStudent(HttpServletRequest req) {
        String name = req.getParameter("name");
        String sex = req.getParameter("sex");
        String age = req.getParameter("age");
        String major = req.getParameter("major");
        String phone = req.getParameter("phone");
        String class_id = req.getParameter("class_id");
        boolean i = studentService.insert(new Student.Builder().name(name).sex(sex).age(Integer.valueOf(age)).major(major).phone(phone).class_id(Integer.valueOf(class_id)).build());
        if (i) {
            return new Result.Builder().successMsg("添加学生成功").build();
        } else {
            return new Result.Builder().errorMsg("添加学生失败").build();
        }
    }

    @ResponseBody
    @RequestMapping("/editStudent")
    public Result editStudent(HttpServletRequest req) {
        String id = req.getParameter("id");
        String name = req.getParameter("name");
        String sex = req.getParameter("sex");
        String age = req.getParameter("age");
        String major = req.getParameter("major");
        String phone = req.getParameter("phone");
        String class_id = req.getParameter("class_id");
        boolean i = studentService.update(new Student.Builder().id(Integer.valueOf(id)).name(name).sex(sex).age(Integer.valueOf(age)).major(major).phone(phone).class_id(Integer.valueOf(class_id)).build());
        if (i) {
            return new Result.Builder().successMsg("编辑学生成功").build();
        } else {
            return new Result.Builder().errorMsg("编辑学生失败").build();
        }
    }


    @ResponseBody
    @RequestMapping("/removeStudent")
    public Result removeStudent(HttpServletRequest req) {
        String id = req.getParameter("id");
        boolean i = studentService.deleteById(Integer.valueOf(id));
        if (i) {
            return new Result.Builder().successMsg("删除学生成功").build();
        } else {
            return new Result.Builder().errorMsg("删除学生失败").build();
        }
    }


}
