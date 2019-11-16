package com.javamultiplex.fundmanagerapp.model;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class UserContributionDTO implements Serializable {
    private static final long serialVersionUID = 3819560651420487997L;
    private Long id;
    private String month;
    private String amount;
    private Long userId;

}
