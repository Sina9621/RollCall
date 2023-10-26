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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private LocalDateTime enterTime;

    @Column
    private LocalDateTime exitTime;

    @ManyToOne
    private Employee employee;

}
