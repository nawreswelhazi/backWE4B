package com.example.WE4B.models;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serializable;


@Embeddable
public class RDVkey implements Serializable {

        @Column(name = "medecin_id")
        Long medecin_id;

        @Column(name = "patient_id")
        Long patient_id;
}
