package com.javamultiplex.fundmanagerapp.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "USER_CONTRIBUTION")
public class UserContribution {
    @Id
    @GeneratedValue
    private Long id;
    private String month;
    private String amount;

}
