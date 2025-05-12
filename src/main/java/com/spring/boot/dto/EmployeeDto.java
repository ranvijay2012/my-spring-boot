package com.spring.boot.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeDto implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private Long empId;
    private String empName;
    private String sex;
}
