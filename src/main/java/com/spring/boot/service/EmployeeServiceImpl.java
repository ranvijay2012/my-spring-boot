package com.spring.boot.service;

import com.spring.boot.dto.Employee;
import com.spring.boot.repository.EmployeeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeDao employeeDao;

    @Override
    public List<Employee> getEmployees() {
        return employeeDao.getEmployees();
    }

    @Override
    public Employee getEmployee(Integer empId) {
        return employeeDao.getEmployee(empId);
    }

    @Override
    public Employee saveEmployee(Employee employee) {
        return employeeDao.saveEmployee(employee);
    }

    @Override
    public boolean deleteEmployee(Integer empId) {
        return employeeDao.deleteEmployee(empId);
    }
}
