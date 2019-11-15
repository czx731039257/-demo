package com.demo.sis.controller;

import com.demo.sis.entity.*;
import com.demo.sis.service.StudentService;
import com.demo.sis.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@Controller
public class TeacherAction {

    @Autowired
    private TeacherService teacherService;

    @ResponseBody
    @RequestMapping("/queryAllTeacher")
    public Page queryAllTeacher(HttpServletRequest req) throws IOException {
        Integer pageNumber = Integer.valueOf(req.getParameter("page"));
        Integer pageSize = Integer.valueOf(req.getParameter("rows"));
        String id = req.getParameter("id");
        String name = req.getParameter("name");
        Page page = new Page.Builder().pageNumber(pageNumber).pageSize(pageSize).startIndex((pageNumber - 1) * pageSize).build();

        Teacher teacher = new Teacher();
        if (StringUtils.isNoBlank(id)) {
            teacher.setId(Integer.valueOf(id));
            page.setTeacher(teacher);
        }
        if (StringUtils.isNoBlank(name)) {
            teacher.setName(name);
            page.setTeacher(teacher);
        }
        page = teacherService.findpage(page);
        return page;
    }


    @ResponseBody
    @RequestMapping("/insertTeacher")
    public Result insertTeacher(HttpServletRequest req) {
        String name = req.getParameter("name");
        String sex = req.getParameter("sex");
        String age = req.getParameter("age");
        String phone = req.getParameter("phone");
        boolean i = teacherService.insert(new Teacher.Builder().name(name).sex(sex).age(Integer.valueOf(age)).phone(phone).build());
        if (i) {
            return new Result.Builder().successMsg("添加教师成功").build();
        } else {
            return new Result.Builder().errorMsg("添加教师失败").build();
        }
    }

    @ResponseBody
    @RequestMapping("/editTeacher")
    public Result editTeacher(HttpServletRequest req) {
        String id = req.getParameter("id");
        String name = req.getParameter("name");
        String sex = req.getParameter("sex");
        String age = req.getParameter("age");
        String phone = req.getParameter("phone");
        boolean i = teacherService.update(new Teacher.Builder().id(Integer.valueOf(id)).name(name).sex(sex).age(Integer.valueOf(age)).phone(phone).build());
        if (i) {
            return new Result.Builder().successMsg("编辑教师成功").build();
        } else {
            return new Result.Builder().errorMsg("编辑教师失败").build();
        }
    }


    @ResponseBody
    @RequestMapping("/removeTeacher")
    public Result removeTeacher(HttpServletRequest req) {
        String id = req.getParameter("id");
        boolean i = teacherService.deleteById(Integer.valueOf(id));
        if (i) {
            return new Result.Builder().successMsg("删除教师成功").build();
        } else {
            return new Result.Builder().errorMsg("删除教师失败").build();
        }
    }


}
