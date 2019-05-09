package com.codecool.gaborkallos.glidertowing.service;


import com.codecool.gaborkallos.glidertowing.model.Flight;
import com.codecool.gaborkallos.glidertowing.model.Glider;
import com.codecool.gaborkallos.glidertowing.model.TowingAirplane;
import com.codecool.gaborkallos.glidertowing.repository.TowingAirplaneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TowingAirplaneService {

    private TowingAirplaneRepository towingAirplaneRepository;

    @Autowired
    public TowingAirplaneService(TowingAirplaneRepository towingAirplaneRepository) {
        this.towingAirplaneRepository = towingAirplaneRepository;
    }

    public void save(TowingAirplane towingAirplane) {
        towingAirplaneRepository.save(towingAirplane);
    }

    public boolean towingIsExist(TowingAirplane newtowing) {
        List<TowingAirplane> towings = towingAirplaneRepository.findAll();
        for (TowingAirplane towing : towings) {
            if (towing.getRegistrationNumber().equals(newtowing.getRegistrationNumber())) {
                return true;
            }
        }
        return false;
    }

    public TowingAirplane findTowing(Flight flight) {
        if (towingIsExist(flight.getTowingAirplane())) {
            List<TowingAirplane> all = towingAirplaneRepository.findAll();
            for (TowingAirplane towing : all) {
                if (towing.getRegistrationNumber().equals(flight.getTowingAirplane().getRegistrationNumber())) {
                    return towing;
                }
            }
        }
        return null;
    }
}
