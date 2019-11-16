package com.javamultiplex.fundmanagerapp.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "EXPENSES")
@Data
public class Expenses {

    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String amount;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "event_id")
    private Event event;

    public Expenses(String name, String amount) {
        this.name = name;
        this.amount = amount;
    }
}
