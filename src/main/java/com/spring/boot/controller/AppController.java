package com.spring.boot.controller;

import com.spring.boot.constant.SuccessDetails;
import com.spring.boot.dataConfig.AddressServiceTemplateImpl;
import com.spring.boot.exception.ApplicationException;
import com.spring.boot.service.EmployeeService;
import com.spring.boot.service.dto.EmployeeDto;
import com.spring.boot.service.dto.ResponseDto;
import com.spring.boot.utility.ResponseUtil;
import io.swagger.v3.oas.annotations.Operation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api")
public class AppController {

    @Autowired
    private ResponseUtil responseUtil;

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private AddressServiceTemplateImpl addressService;

    @GetMapping()
    @Operation(summary = "Welcome method")
    public String getWelcome() {
        log.info("This is an info message from address service: {}", addressService.getData());
        return "Welcome to practice on spring-boot";
    }

    @GetMapping("/employees")
//    @PreAuthorize("hasRole('ADMIN')")
    @Operation(summary = "Get all employees list from DB")
    public ResponseEntity<ResponseDto<?>> getEmployees() {
        log.info("Get all employeeDtos list from DB");
        List<EmployeeDto> employeeDtos = employeeService.getEmployees();
        return responseUtil.getSuccessResponseWithDataDto(employeeDtos, SuccessDetails.EMPLOYEE_LIST_GET_SUCCESSFULLY);
    }

    @GetMapping("/employee/{empId}")
    @Operation(summary = "Get only employee from DB with id")
    public ResponseEntity<ResponseDto<?>> getEmployee(@PathVariable("empId") Long empId) {
        log.info("Get only employeeDto from DB with id: {}", empId);
        EmployeeDto employeeDto = employeeService.getEmployee(empId);
        return responseUtil.getSuccessResponseWithDataDto(employeeDto, SuccessDetails.EMPLOYEE_GET_SUCCESSFULLY);
    }

    @PostMapping("/employee")
//    @PreAuthorize("hasRole('ADMIN')")
    @Operation(summary = "Save employeeDto in DB")
    public ResponseEntity<ResponseDto<?>> saveEmployee(@RequestBody EmployeeDto employeeDto) throws ApplicationException {
        log.info("Save employeeDto in DB employeeDto is: {}", employeeDto);
        EmployeeDto employeeDto1 = employeeService.saveEmployee(employeeDto);
        return responseUtil.getSuccessResponseWithDataDto(employeeDto1, SuccessDetails.EMPLOYEE_SAVED_SUCCESSFULLY);
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
