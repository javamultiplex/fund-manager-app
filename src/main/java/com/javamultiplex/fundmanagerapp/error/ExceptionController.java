package com.javamultiplex.fundmanagerapp.error;

import com.javamultiplex.fundmanagerapp.model.ErrorResponse;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class ExceptionController extends ResponseEntityExceptionHandler {

    @ExceptionHandler(ServiceException.class)
    public ResponseEntity<ErrorResponse> handleServiceException(ServiceException ex){
        ErrorResponse errorResponse = ex.getErrorResponse();
        int errorCode = errorResponse.getErrorCode();
        return new ResponseEntity<>(errorResponse, HttpStatus.valueOf(errorCode));
    }
}
