package com.javamultiplex.fundmanagerapp.model;


import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class ExpenseDTO implements Serializable {

    private static final long serialVersionUID = -5533633585217827085L;

    private String name;
    private String amount;
    private Long eventId;

}
