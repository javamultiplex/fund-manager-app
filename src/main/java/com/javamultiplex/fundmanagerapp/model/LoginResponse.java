package com.javamultiplex.fundmanagerapp.model;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class LoginResponse implements Serializable {

    private static final long serialVersionUID = 1797406510328265920L;

    private String name;
    private Long userId;

    public LoginResponse(String name, Long userId) {
        this.name = name;
        this.userId = userId;
    }
}
