package com.spring.boot.controller;

import io.swagger.v3.oas.annotations.Operation;
import com.spring.boot.dto.Employee;
import com.spring.boot.service.EmployeeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("api")
public class AppController {

    @GetMapping()
    @Operation(summary = "Welcome method")
    public String getWelcome(){
        log.info("INFO: This is an info message");
        log.warn("WARN: This is a warning");
        log.error("ERROR: Something went wrong");
        return "Welcome to practice on spring-boot";
    }

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/employees")
    @PreAuthorize("hasRole('ADMIN')")
    @Operation(summary = "Get all employees list")
    public List<Employee> getEmployees(){
        return employeeService.getEmployees();
    }

    @GetMapping("/employee/{empId}")
    public Employee getEmployee(@PathVariable("empId") Integer empId){
        return employeeService.getEmployee(empId);
    }

    @PostMapping("/employee")
//    @PreAuthorize("hasRole('ADMIN')")
    public Employee saveEmployee(@RequestBody Employee employee){
        System.out.println("Employee details: "+employee);
        return employeeService.saveEmployee(employee);
    }

    @DeleteMapping("/employee/{empId}")
//    @PreAuthorize("hasRole('USER')")  // Use hasRole for role-based access control
    public boolean deleteEmployee(@PathVariable("empId") Integer empId){
        return employeeService.deleteEmployee(empId);
    }
}
