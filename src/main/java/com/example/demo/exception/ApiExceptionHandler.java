package com.example.demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.ZonedDateTime;

@ControllerAdvice // allow there to be more than one exception, but right now there is just the ApiRequestException
public class ApiExceptionHandler {

    // how does this class get called?? @ExceptionHandler annotation
    @ExceptionHandler(value = ApiRequestException.class) // @ExceptionHandler == I want this method to handle exceptions called ApiRequestException
    public ResponseEntity<Object> handleApiRequestException(ApiRequestException e){
        ApiException apiException = new ApiException(e.getMessage(),
                e,
                HttpStatus.BAD_REQUEST,
                ZonedDateTime.now()
        );

        return new ResponseEntity<>(
                apiException,
                HttpStatus.BAD_REQUEST
        );
    }
}
