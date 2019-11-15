package com.csx.ems.controller;

import com.alibaba.fastjson.JSON;
import com.csx.ems.entity.Employee;
import com.csx.ems.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class EmployeeAction {
    @Autowired
    private EmployeeService employeeService;

    /**
     * 查看所有员工的信息
     * @return
     */
    @ResponseBody
    @RequestMapping("queryAllEmployee")
    public String queryAllEmployee(){
        List<Employee> employees = employeeService.queryAllEmployee();
        String data = JSON.toJSONString(employees);
        String json="{\"code\":0,\"msg\":\"\",\"count\":"+employees.size()+",\"data\":"+data+"}";
        return json;
    }

    

}
