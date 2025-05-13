package com.spring.boot.entity;

import jakarta.persistence.*;
import jakarta.transaction.UserTransaction;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "employee")
@Entity
public class EmployeeEntity implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name= "EMP_ID")
    private Long empId;
    @Column(name= "EMP_NAME")
    private String empName;
    @Column(name= "EMP_SEX")
    private String empSex;
}
