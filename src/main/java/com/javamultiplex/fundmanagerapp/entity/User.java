package com.javamultiplex.fundmanagerapp.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "USER")
@Getter
@Setter
public class User implements Serializable {

    private static final long serialVersionUID = -5651999668780412351L;
    @Id
    @GeneratedValue
    private Long id;
    private String email;
    private String phone;
    private String name;
    private String dob;
    private String role;
    private Date registrationDate;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
    private List<UserContribution> userContributions=new ArrayList<>();

    public void addUserContribution(UserContribution userContribution) {
        userContributions.add(userContribution);
        userContribution.setUser(this);
    }
}
