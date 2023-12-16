package com.example.WE4B.services;

import com.example.WE4B.models.medecin;
import org.springframework.http.ResponseEntity;

public interface medecinService {
    ResponseEntity<?> modifierMedecin(Long id, medecin p1);

}
