package com.demo.sis.controller;

import com.demo.sis.entity.Class;
import com.demo.sis.entity.Page;
import com.demo.sis.entity.Result;
import com.demo.sis.entity.StringUtils;
import com.demo.sis.entity.Student;
import com.demo.sis.service.ClassService;
import com.demo.sis.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@Controller
public class ClassAction {

    @Autowired
    private ClassService classService;

    @ResponseBody
    @RequestMapping("/queryAllClass")
    public Page queryAllClass(HttpServletRequest req) throws IOException {
        Integer pageNumber = Integer.valueOf(req.getParameter("page"));
        Integer pageSize = Integer.valueOf(req.getParameter("rows"));
        String id = req.getParameter("id");
        String name = req.getParameter("name");
        String instructor=req.getParameter("instructor");
        Page page=new Page.Builder().pageNumber(pageNumber).pageSize(pageSize).startIndex((pageNumber-1)*pageSize).build();

        Class c=new Class();
        if(StringUtils.isNoBlank(id)){
            c.setId(Integer.valueOf(id));
            page.setC(c);
        }
        if(StringUtils.isNoBlank(name)){
            c.setName(name);
            page.setC(c);
        }
        if(StringUtils.isNoBlank(instructor)){
            c.setInstructor(instructor);
            page.setC(c);
        }
        page = classService.findpage(page);
        return page;
    }


    @ResponseBody
    @RequestMapping("/insertClass")
    public Result insertClass(HttpServletRequest req){
        String name = req.getParameter("name");
        String monitor_id = req.getParameter("monitor_id");
        String number = req.getParameter("number");
        String instructor = req.getParameter("instructor");
        boolean i=classService.insert(new Class.Builder().name(name).monitor_id(Integer.valueOf(monitor_id)).number(Integer.valueOf(number)).instructor(instructor).build());
        if(i) {
            return new Result.Builder().successMsg("添加班级成功").build();
        }else{
            return new Result.Builder().errorMsg("添加班级失败").build();
        }
    }

    @ResponseBody
    @RequestMapping("/editClass")
    public Result editClass(HttpServletRequest req){
        String id = req.getParameter("id");
        String name = req.getParameter("name");
        String monitor_id = req.getParameter("monitor_id");
        String number = req.getParameter("number");
        String instructor = req.getParameter("instructor");
        boolean i = classService.update(new Class.Builder().id(Integer.valueOf(id)).name(name).monitor_id(Integer.valueOf(monitor_id)).number(Integer.valueOf(number)).instructor(instructor).build());
        if(i){
            return new Result.Builder().successMsg("编辑班级成功").build();
        }else{
            return new Result.Builder().errorMsg("编辑班级失败").build();
        }
    }


    @ResponseBody
    @RequestMapping("/removeClass")
    public Result removeClass(HttpServletRequest req){
        String id = req.getParameter("id");
        boolean i = classService.deleteById(Integer.valueOf(id));
        if(i){
            return new Result.Builder().successMsg("删除班级成功").build();
        }else{
            return new Result.Builder().errorMsg("删除班级失败").build();
        }
    }



}
