package com.javamultiplex.fundmanagerapp.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "USER_CONTRIBUTION")
@Getter
@Setter
@NoArgsConstructor
public class UserContribution {
    @Id
    @GeneratedValue
    private Long id;
    private String month;
    private String amount;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;
    public UserContribution(String month, String amount) {
        this.month = month;
        this.amount = amount;
    }
}
