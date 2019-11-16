package com.javamultiplex.fundmanagerapp.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "EVENT")
@Data
public class Event {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "event_name")
    private String name;

    @Column(name = "event_date")
    private String date;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "event")
    private List<Expenses> expenses;

    public void addExpenses(Expenses expense) {
        expenses.add(expense);
        expense.setEvent(this);
    }
}
