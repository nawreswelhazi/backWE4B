package com.example.WE4B.controllers;

import com.example.WE4B.models.RDV;
import com.example.WE4B.repositories.rdvRepository;
import com.example.WE4B.services.rdvService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/rdvs")
public class RDVController {
    @Autowired
    public rdvRepository rdvRep;

    @Autowired
    public rdvService rs;

    @GetMapping("/get/{id}")
    public ResponseEntity getRDVMedecin(@PathVariable Long id){
        List<RDV> lst1 = rdvRep.rdvMedecin(id);
        if (lst1.isEmpty())
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        return new ResponseEntity(lst1,HttpStatus.OK);
    }



    @GetMapping("/getRDVMedecinExist/{id}/{date}")
    public ResponseEntity<?> getRDVMedecinExist(@PathVariable Long id, @PathVariable String date){
        List<String> heuresDisponibles = new ArrayList<>();
        LocalDate localDate = LocalDate.parse(date);
        List<LocalTime> heures = rs.genererHeuresEntre8hEt17h();
        for (LocalTime heure : heures){
            LocalTime newTime = LocalTime.of(heure.getHour(), heure.getMinute(), 0);
            Optional<RDV> rdv = rdvRep.rdvExists(id, localDate, newTime);
            if (!rdv.isPresent())
                heuresDisponibles.add(newTime.toString());
        }
        return new ResponseEntity(heuresDisponibles,HttpStatus.OK);
    }


}
