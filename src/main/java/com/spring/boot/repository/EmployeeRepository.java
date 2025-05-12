package com.spring.boot.repository;

import com.spring.boot.entity.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EmployeeRepository extends JpaRepository<EmployeeEntity, Long> {

    @Override
    Optional<EmployeeEntity> findById(Long empId);
}
