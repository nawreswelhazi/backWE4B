package com.example.WE4B.services;

import com.example.WE4B.models.patient;
import org.springframework.http.ResponseEntity;

public interface patientService {
    ResponseEntity<?> modifierPatient(Long id, patient p1);

}
