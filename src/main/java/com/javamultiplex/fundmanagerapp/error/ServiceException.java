package com.javamultiplex.fundmanagerapp.error;

import com.javamultiplex.fundmanagerapp.model.ErrorResponse;
import lombok.Getter;

@Getter
public class ServiceException extends RuntimeException{
    private ErrorResponse errorResponse;

    public ServiceException(ErrorResponse errorResponse) {
        this.errorResponse = errorResponse;
    }
}
