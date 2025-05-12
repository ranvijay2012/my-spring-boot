package com.spring.boot.service.impl;

import com.spring.boot.entity.EmployeeEntity;
import com.spring.boot.exception.ResourceNotFoundException;
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
    public EmployeeEntity saveEmployee(EmployeeEntity employee) {
        log.info("Now going to save data is: {}",employee);
        try{
            employeeRepository.save(employee);
        } catch (Exception ex){
            throw new ResourceNotFoundException(ex.getMessage());
        }
        return employeeRepository.save(employee);
    }

    @Override
    public void deleteEmployee(Long empId) {
         employeeRepository.deleteById(empId);
    }
}
