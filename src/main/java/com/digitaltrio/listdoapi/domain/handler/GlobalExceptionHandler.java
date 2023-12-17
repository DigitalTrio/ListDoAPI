package com.digitaltrio.listdoapi.domain.handler;

import com.digitaltrio.listdoapi.data.exceptions.EmptyValuesException;
import com.digitaltrio.listdoapi.domain.responses.error.BadRequestErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(EmptyValuesException.class)
    public ResponseEntity<BadRequestErrorResponse> handleEmptyValuesException(EmptyValuesException ex) {
        BadRequestErrorResponse errorResponse = new BadRequestErrorResponse(ex.getEmptyFields());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
    }
}