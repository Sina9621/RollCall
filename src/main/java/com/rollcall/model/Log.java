package com.rollcall.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Table
@Entity
@NoArgsConstructor
@Getter
@Setter
public class Log {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;

    @Column
    private LocalDateTime enterTime;

    @Column
    private LocalDateTime exitTime;

    @ManyToOne
    private Employee employee;

}
