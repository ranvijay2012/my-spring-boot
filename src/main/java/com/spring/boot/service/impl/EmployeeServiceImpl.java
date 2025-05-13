package com.spring.boot.service.impl;

import com.spring.boot.constant.ErrorDetails;
import com.spring.boot.entity.EmployeeEntity;
import com.spring.boot.exception.ApplicationException;
import com.spring.boot.repository.EmployeeRepository;
import com.spring.boot.service.EmployeeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public List<EmployeeEntity> getEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public EmployeeEntity getEmployee(Long empId) {
        Optional<EmployeeEntity> optionalEmployee = employeeRepository.findById(empId);
        return optionalEmployee.orElseGet(EmployeeEntity::new);
    }

    @Override
    public EmployeeEntity saveEmployee(EmployeeEntity employee) throws ApplicationException {
        log.info("Now going to save data is: {}", employee);
        try {
            employee = employeeRepository.save(employee);
        } catch (Exception ex) {
            log.error("Employee data could not be save due to {}", ex.getMessage());
            throw new ApplicationException(ErrorDetails.EMPLOYEE_DATA_UNABLE_TO_SAVE, ex);
        }
        return employee;
    }

    @Override
    public void deleteEmployee(Long empId) {
        employeeRepository.deleteById(empId);
    }
}
