package com.example.WE4B.models;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="typePersonne", discriminatorType = DiscriminatorType.STRING)
public class personne implements Serializable{
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long id;
    @Column(nullable = false)
    private String nom;
    @Column(nullable = false)
    private String prenom;
    @Column(nullable = false)
    private int age;
    @Column(nullable = false)
    private int sexe;
    @Column(nullable = false)
    private String adresse;
    @Column(nullable = false, unique=true)
    private String mail;
}
