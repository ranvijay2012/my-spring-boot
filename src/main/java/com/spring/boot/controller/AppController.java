package com.spring.boot.controller;

import com.spring.boot.constant.SuccessDetails;
import com.spring.boot.dto.ResponseDto;
import com.spring.boot.entity.EmployeeEntity;
import com.spring.boot.exception.ApplicationException;
import com.spring.boot.service.EmployeeService;
import com.spring.boot.utility.ResponseUtil;
import io.swagger.v3.oas.annotations.Operation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("api")
public class AppController {

    @Autowired
    private ResponseUtil responseUtil;

    @GetMapping()
    @Operation(summary = "Welcome method")
    public String getWelcome() {
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
    public ResponseEntity<ResponseDto<?>> getEmployees() {
        log.info("Get all employees list from DB");
        List<EmployeeEntity> employees = employeeService.getEmployees();
        return responseUtil.getSuccessResponseWithDataDto(employees, SuccessDetails.EMPLOYEE_LIST_GET_SUCCESSFULLY);
    }

    @GetMapping("/employee/{empId}")
    @Operation(summary = "Get only employee from DB with id")
    public ResponseEntity<ResponseDto<?>> getEmployee(@PathVariable("empId") Long empId) {
        log.info("Get only employee from DB with id: {}", empId);
        EmployeeEntity employee = employeeService.getEmployee(empId);
        return responseUtil.getSuccessResponseWithDataDto(employee, SuccessDetails.EMPLOYEE_GET_SUCCESSFULLY);
    }

    @PostMapping("/employee")
//    @PreAuthorize("hasRole('ADMIN')")
    @Operation(summary = "Save employee in DB")
    public ResponseEntity<ResponseDto<?>> saveEmployee(@RequestBody EmployeeEntity employee) throws ApplicationException {
        log.info("Save employee in DB employee is: {}", employee);
        EmployeeEntity employeeEntity = employeeService.saveEmployee(employee);
        return responseUtil.getSuccessResponseWithDataDto(employeeEntity, SuccessDetails.EMPLOYEE_SAVED_SUCCESSFULLY);
    }

    @DeleteMapping("/employee/{empId}")
    @Operation(summary = "Delete employee from DB filtered with id")
//    @PreAuthorize("hasRole('USER')")  // Use hasRole for role-based access control
    public ResponseEntity<ResponseDto<?>> deleteEmployee(@PathVariable("empId") Long empId) {
        log.info("Delete employee in DB id is: {}", empId);
        employeeService.deleteEmployee(empId);
        return responseUtil.getSuccessResponseDto(SuccessDetails.EMPLOYEE_DELETED_SUCCESSFULLY);
    }
}
