package com.example.WE4B.serviceImpl;

import com.example.WE4B.models.medecin;
import com.example.WE4B.repositories.medecinRepository;
import com.example.WE4B.services.medecinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import java.util.Optional;
@Service
public class medecinServiceImpl implements medecinService {

    @Autowired
    private medecinRepository PR;
    @Override
    public ResponseEntity<?> modifierMedecin(@PathVariable Long id, @RequestBody medecin p1){

        Optional<medecin> p = PR.findById(id);
        if (!p.isPresent())
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        medecin a2 = p.get();
        a2.setExperience(p1.getExperience());
        a2.setPrix(p1.getPrix());
        a2.setPresentation(p1.getPresentation());
        a2.setHeureFermeture(p1.getHeureFermeture());
        a2.setHeureOuverture(p1.getHeureOuverture());

        medecin a3 = PR.save(a2);
        return new ResponseEntity(a3, HttpStatus.OK);
    }
}
