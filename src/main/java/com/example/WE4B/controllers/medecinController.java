package com.example.WE4B.controllers;

import com.example.WE4B.models.medecin;
import com.example.WE4B.models.patient;
import com.example.WE4B.repositories.medecinRepository;
import com.example.WE4B.repositories.patientRepository;
import com.example.WE4B.services.medecinService;
import com.example.WE4B.services.patientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/medecin")
public class medecinController {
    @Autowired
    public medecinService MS;

    @Autowired
    public medecinRepository MR;

    @PostMapping(value = "/new")
    public ResponseEntity save(@RequestBody medecin M) {
        if (MR.medecinExists(M.getMail(), M.getCodeINE()).isPresent())
            return new ResponseEntity<>(HttpStatus.FOUND);
        medecin M2 = MR.save(M);
        return new ResponseEntity<>(M2, HttpStatus.CREATED);
    }

    @GetMapping("/all")
    public ResponseEntity<List<medecin>> listerMedecins(){
        List<medecin> lst1 = MR.findAll();
       // if (lst1.isEmpty())
           //return new ResponseEntity(HttpStatus.NO_CONTENT);
        return new ResponseEntity(lst1, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity supprimerMedecin(@PathVariable Long id){
        Optional<medecin> m = MR.findById(id);
        if (!(m.isPresent()))
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        MR.deleteById(id);
        return new ResponseEntity(m,HttpStatus.OK);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity getMedecin(@PathVariable Long id){
        Optional<medecin> a = MR.findById(id);
        if (!(a.isPresent()))
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        MR.findById(id);
        return new ResponseEntity(a,HttpStatus.OK);
    }

    @GetMapping("/getMedecinsBySpecialiteVille/{specialite}/{ville}")
    public ResponseEntity getMedecinsSv(@PathVariable String specialite,@PathVariable String ville){
        List<medecin> lst1 = MR.findBySpecialiteVille(specialite,ville);
        //if (lst1.isEmpty())
           // return new ResponseEntity(HttpStatus.NOT_FOUND);
        return new ResponseEntity(lst1,HttpStatus.OK);
    }
    @GetMapping("/getMedecinsBySpecialite/{specialite}")
    public ResponseEntity getMedecinsS(@PathVariable String specialite){
        List<medecin> lst1 = MR.findBySpecialite(specialite);
        //if (lst1.isEmpty())
        // return new ResponseEntity(HttpStatus.NOT_FOUND);
        return new ResponseEntity(lst1,HttpStatus.OK);
    }
    @GetMapping("/getMedecinsByVille/{ville}")
    public ResponseEntity getMedecinsV(@PathVariable String ville){
        List<medecin> lst1 = MR.findByville(ville);
        //if (lst1.isEmpty())
        // return new ResponseEntity(HttpStatus.NOT_FOUND);
        return new ResponseEntity(lst1,HttpStatus.OK);
    }


    @PutMapping("/update/{id}")
    public ResponseEntity<?> modifierMedecin(@PathVariable Long id, @RequestBody medecin m1){
        ResponseEntity<?> lst = MS.modifierMedecin(id, m1);
        return lst;
    }
}
