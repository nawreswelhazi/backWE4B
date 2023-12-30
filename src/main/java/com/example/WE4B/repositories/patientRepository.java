package com.example.WE4B.repositories;

import com.example.WE4B.models.patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface patientRepository extends JpaRepository<patient,Long> {
    @Query("FROM patient WHERE mail = ?1 or num_assurance = ?2")
    public Optional<patient> patientExists(String mail, String numAssurance);

    @Query("FROM patient WHERE mail = ?1 and mdp = ?2")
    public Optional<patient> patientCredentials(String mail, String mdp);


}
