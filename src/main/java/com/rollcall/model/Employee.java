package com.rollcall.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Set;

@Table
@Entity
@NoArgsConstructor
@Getter
@Setter
public class Employee implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String name;
    @Column
    private String lastName;

    @Column
    private String cardKey;

    @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL)
    private Set<Log> logs;

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", cardKey='" + cardKey + '\'' +
                ", logs=" + logs +
                '}';
    }
}