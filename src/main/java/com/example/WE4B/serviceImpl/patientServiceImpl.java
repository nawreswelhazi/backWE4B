package com.example.WE4B.serviceImpl;

import com.example.WE4B.models.patient;
import com.example.WE4B.repositories.patientRepository;
import com.example.WE4B.services.patientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Optional;

@Service
public class patientServiceImpl implements patientService {
    @Autowired
    private patientRepository PR;
    @Override
    public ResponseEntity<?> modifierPatient(@PathVariable Long id, @RequestBody patient p1){

        Optional<patient> p = PR.findById(id);
        if (!p.isPresent())
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        patient a2 = p.get();
        a2.setTaille(p1.getTaille());
        a2.setPoids(p1.getPoids());
        a2.setAdresse(p1.getAdresse());
        a2.setAge(p1.getAge());
        a2.setPhoto(p1.getPhoto());

        patient a3 = PR.save(a2);
        return new ResponseEntity(a3, HttpStatus.OK);
    }
}
