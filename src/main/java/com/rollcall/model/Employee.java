package com.rollcall.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Table
@Entity
@NoArgsConstructor
@Getter
@Setter
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;
    @Column
    private String name;
    @Column
    private String lastName;

    @Column
    private String cardKey;

    @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL)
    private Set<Log> logs;

}