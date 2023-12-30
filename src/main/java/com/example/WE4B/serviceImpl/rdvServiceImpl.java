package com.example.WE4B.serviceImpl;


import com.example.WE4B.services.rdvService;
import org.springframework.stereotype.Service;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class rdvServiceImpl implements rdvService {
    public List<LocalTime> genererHeuresEntre8hEt17h() {
        List<LocalTime> heures = new ArrayList<>();
        LocalTime heureDebut = LocalTime.of(8, 0);
        LocalTime heureFin = LocalTime.of(17, 0);

        while (heureDebut.isBefore(heureFin)) {
            heures.add(heureDebut);
            heureDebut = heureDebut.plusHours(1);
        }
        return heures;
    }
}
