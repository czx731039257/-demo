package com.demo.sis.controller;

import com.demo.sis.entity.*;
import com.demo.sis.service.CourseService;
import com.demo.sis.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@Controller
public class CourseAction {

    @Autowired
    private CourseService courseService;

    @ResponseBody
    @RequestMapping("/queryAllCourse")
    public Page queryAllCourse(HttpServletRequest req) throws IOException {
        Integer pageNumber = Integer.valueOf(req.getParameter("page"));
        Integer pageSize = Integer.valueOf(req.getParameter("rows"));
        String id = req.getParameter("id");
        String name = req.getParameter("name");
        Page page = new Page.Builder().pageNumber(pageNumber).pageSize(pageSize).startIndex((pageNumber - 1) * pageSize).build();

        Course course = new Course();
        if (StringUtils.isNoBlank(id)) {
            course.setId(Integer.valueOf(id));
            page.setCourse(course);
        }
        if (StringUtils.isNoBlank(name)) {
            course.setName(name);
            page.setCourse(course);
        }
        page = courseService.findpage(page);
        return page;
    }


    @ResponseBody
    @RequestMapping("/insertCourse")
    public Result insertCourse(HttpServletRequest req) {
        String name = req.getParameter("name");
        String classroom = req.getParameter("classroom");
        String date = req.getParameter("date");
        String credit = req.getParameter("credit");
        String teacher_id = req.getParameter("teacher_id");
        boolean i = courseService.insert(new Course.Builder().name(name).classroom(classroom).date(date).credit(Integer.valueOf(credit)).teacher_id(Integer.valueOf(teacher_id)).build());
        if (i) {
            return new Result.Builder().successMsg("添加课程成功").build();
        } else {
            return new Result.Builder().errorMsg("添加课程失败").build();
        }
    }

    @ResponseBody
    @RequestMapping("/editCourse")
    public Result editCourse(HttpServletRequest req) {
        String id = req.getParameter("id");
        String name = req.getParameter("name");
        String classroom = req.getParameter("classroom");
        String date = req.getParameter("date");
        String credit = req.getParameter("credit");
        String teacher_id = req.getParameter("teacher_id");
        boolean i = courseService.update(new Course.Builder().id(Integer.valueOf(id)).name(name).classroom(classroom).date(date).credit(Integer.valueOf(credit)).teacher_id(Integer.valueOf(teacher_id)).build());
        if (i) {
            return new Result.Builder().successMsg("编辑课程成功").build();
        } else {
            return new Result.Builder().errorMsg("编辑课程失败").build();
        }
    }


    @ResponseBody
    @RequestMapping("/removeCourse")
    public Result removeCourse(HttpServletRequest req) {
        String id = req.getParameter("id");
        boolean i = courseService.deleteById(Integer.valueOf(id));
        if (i) {
            return new Result.Builder().successMsg("删除课程成功").build();
        } else {
            return new Result.Builder().errorMsg("删除课程失败").build();
        }
    }


}
