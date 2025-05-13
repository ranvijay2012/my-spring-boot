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
        log.info("Getting employee list from DB ");
        List<Employee> employees = employeeRepository.findAll();
        log.info("Now converting employee entity into dto");
        List<EmployeeDto> employeeDtos = employeeAdopter.mapOneTypeListToAnotherType(employees, EmployeeDto.class);
        log.info("After converting entity to dto then return a dto list with size: {}", employeeDtos.size());
        return employeeDtos;
    }

    @Override
    public EmployeeDto getEmployee(Long empId) {
        log.info("Getting employee detail from DB with ID: {}", empId);
        Optional<Employee> optionalEmployee = employeeRepository.findById(empId);
        log.info("Fetched employee detail successfully from DB");
        Employee employee = optionalEmployee.orElseGet(Employee::new);
        log.info("Map employee entity to dto and return data with ID: {}", empId);
        return (EmployeeDto) employeeAdopter.mapOneObjectToAnother(employee, EmployeeDto.class);
    }

    @Override
    public EmployeeDto saveEmployee(EmployeeDto employeeDto) throws ApplicationException {
        log.info("Map employee dto into entity data is: {}", employeeDto);
        Employee employee = (Employee) employeeAdopter.mapOneObjectToAnother(employeeDto, Employee.class);
        try {
            log.info("Employee data saving in DB");
            employee = employeeRepository.save(employee);
            log.info("Employee data saved successfully in DB with id: {}", employee.getId());
        } catch (Exception ex) {
            log.error("Employee data could not be save due to {}", ex.getMessage());
            throw new ApplicationException(ErrorDetails.EMPLOYEE_DATA_UNABLE_TO_SAVE, ex);
        }
        log.info("Now converting entity to dto and return a dto");
        return (EmployeeDto) employeeAdopter.mapOneObjectToAnother(employee, EmployeeDto.class);
    }

    @Override
    public void deleteEmployee(Long empId) {
        log.info("Deleting employee detail from DB with ID: {}", empId);
        employeeRepository.deleteById(empId);
        log.info("Deleted employee detail from DB successfully");
    }
}
