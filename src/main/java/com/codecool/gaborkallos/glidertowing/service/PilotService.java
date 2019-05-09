package com.codecool.gaborkallos.glidertowing.service;

import com.codecool.gaborkallos.glidertowing.model.Flight;
import com.codecool.gaborkallos.glidertowing.model.Glider;
import com.codecool.gaborkallos.glidertowing.model.Pilot;
import com.codecool.gaborkallos.glidertowing.model.TowingAirplane;
import com.codecool.gaborkallos.glidertowing.repository.PilotRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PilotService {

    private PilotRepository pilotRepository;

    @Autowired
    public void setPilotRepository(PilotRepository pilotRepository) {
        this.pilotRepository = pilotRepository;
    }

    public boolean isPilotIsExist(Pilot newpilot) {
        List<Pilot> pilots = pilotRepository.findAll();
        for (Pilot pilot : pilots) {
            if (pilot.getName().equals(newpilot.getName())) {
                return true;
            }
        }
        return false;
    }

    public void save(Pilot pilot){
        pilotRepository.save(pilot);
    }

    public Pilot findPilot(Flight flight) {
        if (isPilotIsExist(flight.getGliderPilot())) {
            List<Pilot> all = pilotRepository.findAll();
            for (Pilot pilot : all) {
                if (pilot.getName().equals(flight.getGliderPilot().getName())) {
                    return pilot;
                }
            }
        }
        return null;
    }
}
