package com.spring.boot.controller;

import com.spring.boot.dto.ResponseDto;
import com.spring.boot.dto.SuccessDto;
import com.spring.boot.entity.EmployeeEntity;
import io.swagger.v3.oas.annotations.Operation;
import com.spring.boot.service.EmployeeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<ResponseDto<?>> getEmployees(){
        log.info("Get all employees list from DB");
        List<EmployeeEntity> employees = employeeService.getEmployees();
        ResponseDto responseDto = new ResponseDto();
        SuccessDto successDto = new SuccessDto();
        successDto.setSuccessCode("001");
        successDto.setSuccessMessage("Successfully fetched employee list");
        successDto.setData(employees);
        responseDto.setSuccessDto(successDto);
        return new ResponseEntity<>(responseDto, HttpStatus.OK);
    }

    @GetMapping("/employee/{empId}")
    @Operation(summary = "Get only employee from DB with id")
    public ResponseEntity<ResponseDto<?>> getEmployee(@PathVariable("empId") Long empId){
        log.info("Get only employee from DB with id: {}",empId);
        EmployeeEntity employee = employeeService.getEmployee(empId);
        ResponseDto responseDto = new ResponseDto();
        SuccessDto successDto = new SuccessDto();
        successDto.setSuccessCode("002");
        successDto.setSuccessMessage("Successfully fetched employee");
        successDto.setData(employee);
        responseDto.setSuccessDto(successDto);
        return new ResponseEntity<>(responseDto, HttpStatus.OK);
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
