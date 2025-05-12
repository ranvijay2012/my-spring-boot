package com.spring.boot.service;


import com.spring.boot.entity.EmployeeEntity;

import java.util.List;

public interface EmployeeService {
    List<EmployeeEntity> getEmployees();

    EmployeeEntity getEmployee(Long empId);

    EmployeeEntity saveEmployee(EmployeeEntity employee);

    void deleteEmployee(Long empId);
}
