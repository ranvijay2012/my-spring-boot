package com.spring.boot.repository;

import com.spring.boot.dto.Employee;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class EmployeeDao {

    private final List<Employee> employees = new ArrayList<>();

    public void setEmployee(Employee employee) {
        employees.add(employee);
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public Employee getEmployee(Integer empId) {
        return employees.stream().filter(obj -> obj.getEmpId().equals(empId)).findAny().get();
    }

    public Employee saveEmployee(Employee employee) {
        employees.add(employee);
        return employee;
    }

    public boolean deleteEmployee(Integer empId) {
        return employees.remove(employees.stream().filter(obj -> obj.getEmpId().equals(empId)).findAny().get());
    }


}
