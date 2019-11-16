package com.javamultiplex.fundmanagerapp.model;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class LoginRequest implements Serializable {
    private static final long serialVersionUID = -5943044492495808856L;
    private String email;
    private String password;
}
