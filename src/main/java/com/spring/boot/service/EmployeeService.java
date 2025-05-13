package com.spring.boot.service;


import com.spring.boot.entity.EmployeeEntity;
import com.spring.boot.exception.ApplicationException;

import java.util.List;

public interface EmployeeService {
    List<EmployeeEntity> getEmployees();

    EmployeeEntity getEmployee(Long empId);

    EmployeeEntity saveEmployee(EmployeeEntity employee) throws ApplicationException;

    void deleteEmployee(Long empId);
}
