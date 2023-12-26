package com.example.WE4B.services;

import com.example.WE4B.models.medecin;
import org.springframework.http.ResponseEntity;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public interface medecinService {
    ResponseEntity<?> modifierMedecin(Long id, medecin p1);
}
