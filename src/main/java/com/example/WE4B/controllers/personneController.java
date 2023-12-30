package com.example.WE4B.controllers;

import com.example.WE4B.models.patient;
import com.example.WE4B.models.personne;
import com.example.WE4B.repositories.personneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/personne")
public class personneController {
    @Autowired
    public personneRepository PR;

    @GetMapping("/get/{mail}/{mdp}")
    public ResponseEntity getPersonne(@PathVariable String mail, @PathVariable String mdp){
        Optional<personne> a = PR.personneCredentials(mail, mdp);
        if (!(a.isPresent()))
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        return new ResponseEntity(a,HttpStatus.OK);
    }
}
