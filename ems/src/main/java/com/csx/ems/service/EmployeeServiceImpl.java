package com.csx.ems.service;

import com.csx.ems.dao.EmployeeDao;
import com.csx.ems.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    @Autowired
    private EmployeeDao employeeDao;

    @Override
    public List<Employee> queryAllEmployee() {
        List<Employee> employees = employeeDao.queryAllEmployee();
        return employees;
    }
}
