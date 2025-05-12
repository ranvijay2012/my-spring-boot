package com.spring.boot.utility;

import com.spring.boot.dto.ResponseDto;
import com.spring.boot.dto.SuccessDto;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

@Component
public class ResponseUtil<I> {

    public ResponseDto<I> getSuccessResponseDto(I data, HttpStatus httpStatus) {
        ResponseDto responseDto = new ResponseDto();
        SuccessDto successDto = new SuccessDto();
        successDto.setSuccessCode(String.valueOf(httpStatus.value()));
        successDto.setSuccessMessage("Successfully fetched employee");
        successDto.setData(data);
        responseDto.setSuccessDto(successDto);
        return responseDto;
    }
}
