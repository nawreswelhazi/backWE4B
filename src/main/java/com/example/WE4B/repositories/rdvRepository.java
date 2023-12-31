package com.example.WE4B.repositories;

import com.example.WE4B.models.RDV;
import com.example.WE4B.models.medecin;
import com.example.WE4B.models.RDVkey;
import com.example.WE4B.models.patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

public interface rdvRepository extends JpaRepository<RDV, Long> {
    @Query("FROM RDV WHERE Medecin.id = ?1 and date = ?2 and horaire = ?3")
    public Optional<RDV> rdvExists(Long medecinId, LocalDate date, LocalTime horaire);

    @Query("FROM RDV WHERE Medecin.id = ?1")
    public List<RDV> rdvMedecin(Long medecinId);

    @Query("FROM RDV WHERE Patient.id = ?1 AND date >= CURRENT_DATE")
    public List<RDV> rdvPatient(Long patientId);

    @Query("FROM RDV WHERE Medecin.id = ?1 AND date >= CURRENT_DATE")
    public List<RDV> rdvMedecinFutur(Long medecinID);
}
