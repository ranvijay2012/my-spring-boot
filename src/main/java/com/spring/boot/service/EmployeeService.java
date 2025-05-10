package com.spring.boot.service;


import com.spring.boot.dto.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> getEmployees();

    com.spring.boot.dto.Employee getEmployee(Integer empId);

    Employee saveEmployee(Employee employee);

    boolean deleteEmployee(Integer empId);
}
