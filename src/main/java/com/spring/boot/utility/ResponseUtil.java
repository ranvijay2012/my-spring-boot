package com.spring.boot.utility;

import com.spring.boot.constant.ErrorDetails;
import com.spring.boot.constant.SuccessDetails;
import com.spring.boot.dto.ErrorDto;
import com.spring.boot.dto.ResponseDto;
import com.spring.boot.dto.SuccessDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class ResponseUtil<I> {

    public ResponseEntity<ResponseDto<I>> getSuccessResponseWithDataDto(I data, SuccessDetails successDetails) {
        ResponseDto<I> responseDto = new ResponseDto<I>();
        SuccessDto<I> successDto = new SuccessDto<I>();
        successDto.setSuccessCode(successDetails.getCode());
        successDto.setSuccessMessage(successDetails.getMessage());
        successDto.setData(data);
        responseDto.setSuccessDto(successDto);
        return new ResponseEntity<>(responseDto, successDetails.getHttpStatus());
    }

    public ResponseEntity<ResponseDto<I>> getSuccessResponseDto(SuccessDetails successDetails) {
        ResponseDto<I> responseDto = new ResponseDto<I>();
        SuccessDto<I> successDto = new SuccessDto<I>();
        successDto.setSuccessCode(successDetails.getCode());
        successDto.setSuccessMessage(successDetails.getMessage());
        responseDto.setSuccessDto(successDto);
        return new ResponseEntity<>(responseDto, successDetails.getHttpStatus());
    }

    public ResponseEntity<ResponseDto<I>> populateErrorResponse(ErrorDetails errorDetails) {
        ResponseDto<I> responseDto = new ResponseDto<I>();
        ErrorDto errorDto = new ErrorDto();
        errorDto.setErrorCode(errorDetails.getErrorCode());
        errorDto.setErrorMessage(errorDetails.getErrorMessage());
        responseDto.setErrorDto(errorDto);
        return new ResponseEntity<>(responseDto, errorDetails.getHttpStatus());
    }

}
