package com.example.WE4B.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class RDV implements Serializable {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "medecin_id")
    private medecin Medecin;

    @ManyToOne
    @JoinColumn(name = "patient_id")
    private patient Patient;

    @Column(nullable = false)
    private String motif;
    @Column(nullable = false)
    private LocalTime horaire;

    @Column(nullable = false)
    private LocalDate date;



}
