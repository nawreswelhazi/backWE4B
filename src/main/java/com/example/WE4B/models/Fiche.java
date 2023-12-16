package com.example.WE4B.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Fiche implements Serializable {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long id;

    @Column(nullable = false)
    private int freq_cardiaque;
    @Column(nullable = false)
    private float temperature;
    @Column(nullable = true)
    private String symptome;
    @Column(nullable = true)
    private String traitement;
    @Column(nullable = true)
    private String numUrgence;

    @Column(nullable = true)
    private String maladiesChroniques;

    @Column(nullable = false)
    private LocalDate dateCreation;

    @ManyToOne
    private patient patient;

}
