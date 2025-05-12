package com.spring.boot.controller;

import com.spring.boot.entity.EmployeeEntity;
import io.swagger.v3.oas.annotations.Operation;
import com.spring.boot.service.EmployeeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
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
//    @PreAuthorize("hasRole('ADMIN')")
    @Operation(summary = "Get all employees list from DB")
    public List<EmployeeEntity> getEmployees(){
        log.info("Get all employees list from DB");
        return employeeService.getEmployees();
    }

    @GetMapping("/employee/{empId}")
    @Operation(summary = "Get only employee from DB with id")
    public EmployeeEntity getEmployee(@PathVariable("empId") Long empId){
        log.info("Get only employee from DB with id: {}",empId);
        return employeeService.getEmployee(empId);
    }

    @PostMapping("/employee")
//    @PreAuthorize("hasRole('ADMIN')")
    @Operation(summary = "Save employee in DB")
    public EmployeeEntity saveEmployee(@RequestBody EmployeeEntity employee){
        log.info("Save employee in DB employee is: {}",employee);
        return employeeService.saveEmployee(employee);
    }

    @DeleteMapping("/employee/{empId}")
    @Operation(summary = "Delete employee from DB filtered with id")
//    @PreAuthorize("hasRole('USER')")  // Use hasRole for role-based access control
    public void deleteEmployee(@PathVariable("empId") Long empId){
        log.info("Delete employee in DB id is: {}",empId);
         employeeService.deleteEmployee(empId);
    }
}
