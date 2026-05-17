package com.onlineSchool.DevAcademy.common.exception;

import com.onlineSchool.DevAcademy.common.exception.exceptions.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleResourceNotFoundException(
            ResourceNotFoundException ex, WebRequest request) {

        ErrorResponse errorDetails = new ErrorResponse(
                HttpStatus.NOT_FOUND.value(),
                "Content Not Found",
                ex.getMessage(),
                request.getDescription(false).replace("uri=","")
        );
        return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
    }
}
