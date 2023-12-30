package com.example.WE4B.repositories;

import com.example.WE4B.models.personne;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface personneRepository extends JpaRepository<personne,Long>{
    @Query("FROM personne WHERE mail = ?1 and mdp = ?2")
    public Optional<personne> personneCredentials(String mail, String mdp);
}
