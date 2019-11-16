package com.javamultiplex.fundmanagerapp.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@Table(name = "CONTRIBUTION")
public class Contribution {

    @Id
    @GeneratedValue
    private Long id;
    private String month;
    private String amount;
}
