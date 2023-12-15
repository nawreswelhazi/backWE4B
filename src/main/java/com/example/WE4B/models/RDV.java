package com.example.WE4B.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalTime;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class RDV implements Serializable {
    @EmbeddedId
    private RDVkey id;
    @ManyToOne
    @MapsId("medecin_id")
    @JoinColumn(name = "medecin_id")
    private com.example.WE4B.models.medecin medecin;

    @ManyToOne
    @MapsId("patient_id")
    @JoinColumn(name = "patient_id")
    private com.example.WE4B.models.patient patient;

    private String motif;
    private LocalTime horaire;


}
