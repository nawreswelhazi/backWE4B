package com.example.WE4B.controllers;

import com.example.WE4B.models.patient;
import com.example.WE4B.repositories.patientRepository;
import com.example.WE4B.services.patientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/patients")
public class patientController {
    @Autowired
    public patientService PS;

    @Autowired
    public patientRepository patientRep;

    @PostMapping(value = "/new")
    public ResponseEntity save(@RequestBody patient P) {
        if (patientRep.patientExists(P.getMail(), P.getNum_assurance()).isPresent())
            return new ResponseEntity<>(HttpStatus.FOUND);
        patient P2 = patientRep.save(P);
        return new ResponseEntity<>(P2, HttpStatus.CREATED);
    }

    @GetMapping("/all")
    public ResponseEntity<List<patient>> listerPatient(){
        List<patient> lst1 = patientRep.findAll();
        if (lst1.isEmpty())
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        return new ResponseEntity(lst1, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity supprimerPatient(@PathVariable Long id){
        Optional<patient> p = patientRep.findById(id);
        if (!(p.isPresent()))
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        patientRep.deleteById(id);
        return new ResponseEntity(p,HttpStatus.OK);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity getPatient(@PathVariable Long id){
        Optional<patient> a = patientRep.findById(id);
        if (!(a.isPresent()))
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        patientRep.findById(id);
        return new ResponseEntity(a,HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> modifierPatient(@PathVariable Long id, @RequestBody patient p1){
        ResponseEntity<?> lst = PS.modifierPatient(id, p1);
        return lst;
    }

}
