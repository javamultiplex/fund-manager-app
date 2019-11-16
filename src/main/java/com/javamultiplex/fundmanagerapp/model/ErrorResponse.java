package com.javamultiplex.fundmanagerapp.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.Singular;

import java.util.List;

@Builder
@Getter
@Setter
public class ErrorResponse {
    private String userMessage;
    @Singular
    private List<String> developerMessages;
    private int errorCode;
}
