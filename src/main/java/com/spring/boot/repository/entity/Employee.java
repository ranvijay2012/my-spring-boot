package com.spring.boot.repository.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "employee")
@Entity
public class Employee implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name= "ID")
    private Long id;

    @Column(name= "NAME")
    private String name;

    @Column(name= "SEX")
    private String sex;

    @Column(name= "BIRTH_DATE")
    private LocalDate birthDate;

//    @Column(name= "dept")
//    private String dept;


}
