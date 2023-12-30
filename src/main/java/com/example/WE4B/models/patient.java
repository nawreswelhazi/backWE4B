package com.example.WE4B.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@Entity
@DiscriminatorValue("patient")
public class patient extends personne implements Serializable {
    @Column(nullable = true)
    private int poids;
    @Column(nullable = true)
    private float taille;
    @Column(nullable = true, unique=true)
    private  String num_assurance;

    @JsonIgnore
    @OneToMany(mappedBy = "Patient")
    Set<RDV> listeRDV;

    @JsonIgnore
    @OneToMany(mappedBy = "patient")
    Set<Fiche> listeFiches;
}
