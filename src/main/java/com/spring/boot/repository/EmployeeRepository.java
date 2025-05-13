package com.spring.boot.repository;

import com.spring.boot.repository.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    @Override
    Optional<Employee> findById(Long empId);
}
