package com.spring.boot.dto;

import com.spring.boot.entity.EmployeeEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SuccessDto<I>{
    private String successCode;
    private String successMessage;
    private I data;
}
