package com.codecool.gaborkallos.glidertowing.service;


import com.codecool.gaborkallos.glidertowing.model.TowingAirplane;
import com.codecool.gaborkallos.glidertowing.repository.TowingAirplaneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TowingAirplaneService {

    private TowingAirplaneRepository towingAirplaneRepository;

    @Autowired
    public TowingAirplaneService(TowingAirplaneRepository towingAirplaneRepository) {
        this.towingAirplaneRepository = towingAirplaneRepository;
    }

    public void save(TowingAirplane towingAirplane){
        towingAirplaneRepository.save(towingAirplane);
    }
}
