package com.spring.boot.controller;

import io.swagger.v3.oas.annotations.Operation;
import com.spring.boot.dto.Employee;
import com.spring.boot.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api")
public class AppController {

    @GetMapping()
    @Operation(summary = "Welcome method")
    public String getWelcome(){
        return "Welcome to practice on spring-boot";
    }

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/employees")
    @Operation(summary = "Get all employees list")
    public List<Employee> getEmployees(){
        return employeeService.getEmployees();
    }

    @GetMapping("/employee/{empId}")
    public Employee getEmployee(@PathVariable("empId") Integer empId){
        return employeeService.getEmployee(empId);
    }

    @PostMapping("/employee")
    public Employee saveEmployee(@RequestBody Employee employee){
        System.out.println("Employee details: "+employee);
        return employeeService.saveEmployee(employee);
    }

    @DeleteMapping("/employee/{empId}")
    public boolean deleteEmployee(@PathVariable("empId") Integer empId){
        return employeeService.deleteEmployee(empId);
    }
}
