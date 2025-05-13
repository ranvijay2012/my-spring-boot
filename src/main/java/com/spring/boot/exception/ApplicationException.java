package com.spring.boot.exception;

import com.spring.boot.constant.ErrorDetails;
import lombok.Getter;

@Getter
public class ApplicationException extends Exception{
    private final ErrorDetails errorDetails;
    private final Throwable throwable;

    public ApplicationException(ErrorDetails errorDetails, Throwable throwable){
        super(errorDetails.getErrorMessage());
        this.errorDetails = errorDetails;
        this.throwable = throwable;
    }
}
