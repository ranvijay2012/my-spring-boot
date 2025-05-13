package com.spring.boot.service;


import com.spring.boot.exception.ApplicationException;
import com.spring.boot.service.dto.EmployeeDto;

import java.util.List;

public interface EmployeeService {
    List<EmployeeDto> getEmployees();

    EmployeeDto getEmployee(Long empId);

    EmployeeDto saveEmployee(EmployeeDto employeeDto) throws ApplicationException;

    void deleteEmployee(Long empId);
}
