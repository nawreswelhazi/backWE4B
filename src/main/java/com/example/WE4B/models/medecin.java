package com.example.WE4B.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalTime;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@Entity
@DiscriminatorValue("medecin")
public class medecin extends personne implements Serializable {
    @Column(nullable = true, unique=true)
    private String codeINE;
    @Column(nullable = true)
    private String specialite;
    @Column(nullable = true)
    private float prix;
    @Column(nullable = true)
    private String presentation;
    @Column(nullable = true)
    private int experience;
    @Column(nullable = true)
    private LocalTime heureOuverture;
    @Column(nullable = true)
    private LocalTime heureFermeture;

    @JsonIgnore
    @OneToMany(mappedBy = "medecin")
    private Set<RDV> listeRDV;
}
