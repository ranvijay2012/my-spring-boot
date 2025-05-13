package com.spring.boot.service.impl;

import com.spring.boot.constant.ErrorDetails;
import com.spring.boot.repository.entity.Employee;
import com.spring.boot.exception.ApplicationException;
import com.spring.boot.repository.EmployeeRepository;
import com.spring.boot.service.EmployeeService;
import com.spring.boot.service.adopter.EmployeeAdopter;
import com.spring.boot.service.dto.EmployeeDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeAdopter employeeAdopter;

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public List<EmployeeDto> getEmployees() {
        List<Employee> employees = employeeRepository.findAll();
        List<EmployeeDto> employeeDtos = employeeAdopter.mapOneTypeListToAnotherType(employees, EmployeeDto.class);
        return employeeDtos;
    }

    @Override
    public EmployeeDto getEmployee(Long empId) {
        Optional<Employee> optionalEmployee = employeeRepository.findById(empId);
        Employee employee = optionalEmployee.orElseGet(Employee::new);
        return (EmployeeDto) employeeAdopter.mapOneObjectToAnother(employee, EmployeeDto.class);
    }

    @Override
    public EmployeeDto saveEmployee(EmployeeDto employeeDto) throws ApplicationException {
        log.info("Now going to save data is: {}", employeeDto);
        Employee employee = (Employee) employeeAdopter.mapOneObjectToAnother(employeeDto, Employee.class);
        try {
            employee = employeeRepository.save(employee);
        } catch (Exception ex) {
            log.error("Employee data could not be save due to {}", ex.getMessage());
            throw new ApplicationException(ErrorDetails.EMPLOYEE_DATA_UNABLE_TO_SAVE, ex);
        }
        return (EmployeeDto) employeeAdopter.mapOneObjectToAnother(employee, EmployeeDto.class);
    }

    @Override
    public void deleteEmployee(Long empId) {
        employeeRepository.deleteById(empId);
    }
}
