package com.digitaltrio.listdoapi.domain.handler;

import com.digitaltrio.listdoapi.data.exceptions.EmailNotAvailableException;
import com.digitaltrio.listdoapi.data.exceptions.EmptyValuesException;
import com.digitaltrio.listdoapi.data.exceptions.FalsePasswordException;
import com.digitaltrio.listdoapi.data.responses.error.BadRequestErrorResponse;
import com.digitaltrio.listdoapi.data.responses.error.NotFoundResponse;
import com.digitaltrio.listdoapi.data.responses.error.SimpleErrorResponse;
import jakarta.persistence.EntityNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
    Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(EmptyValuesException.class)
    public ResponseEntity<BadRequestErrorResponse> handleEmptyValuesException(EmptyValuesException ex) {
        BadRequestErrorResponse errorResponse = new BadRequestErrorResponse(ex.getEmptyFields());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
    }

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<NotFoundResponse> handleEntityNotFoundException(EntityNotFoundException ex) {
        String cleanedMessage = ex.getMessage().replace("jakarta.persistence.EntityNotFoundException:", "").trim();
        logger.warn(cleanedMessage);
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new NotFoundResponse(cleanedMessage));
    }

    @ExceptionHandler(EmailNotAvailableException.class)
    public ResponseEntity<SimpleErrorResponse> handleEmailNotAvailableException(EmailNotAvailableException ex) {
        return ResponseEntity.status(HttpStatus.CONFLICT).body(new SimpleErrorResponse(ex.getMessage()));
    }

    @ExceptionHandler(FalsePasswordException.class)
    public ResponseEntity<SimpleErrorResponse> handleFalsePasswordException(FalsePasswordException ex) {
        return ResponseEntity.status(HttpStatus.CONFLICT).body(new SimpleErrorResponse(ex.getMessage()));
    }
}