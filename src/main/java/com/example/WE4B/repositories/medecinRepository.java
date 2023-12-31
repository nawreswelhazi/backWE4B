package com.example.WE4B.repositories;

import com.example.WE4B.models.RDV;
import com.example.WE4B.models.medecin;
import com.example.WE4B.models.patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface medecinRepository extends JpaRepository<medecin,Long> {
    @Query("FROM medecin WHERE mail = ?1 or codeINE = ?2")
    public Optional<medecin> medecinExists(String mail, String codeINE);
    @Query("FROM medecin WHERE specialite = ?1 and ville = ?2")
     public List<medecin> findBySpecialiteVille(String specialite,String ville);

}
