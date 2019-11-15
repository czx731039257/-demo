package com.csx.ems;

import com.csx.ems.entity.Employee;
import com.csx.ems.service.EmployeeService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

@SpringBootTest
class EmsApplicationTests {

    @Autowired
    private EmployeeService employeeService;

    @Test
    void contextLoads() {
        List<Employee> employees = employeeService.queryAllEmployee();
    }

    @Test
    public void xx(){

    }
}
