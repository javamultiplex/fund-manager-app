package com.javamultiplex.fundmanagerapp.entity;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "EXPENSES")
@Getter
@Setter
@NoArgsConstructor
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
