package com.csx.ems.dao;

import com.csx.ems.entity.Employee;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeDao {
    public List<Employee> queryAllEmployee();
}
