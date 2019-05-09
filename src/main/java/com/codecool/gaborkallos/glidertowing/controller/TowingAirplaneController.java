package com.codecool.gaborkallos.glidertowing.controller;

import com.codecool.gaborkallos.glidertowing.repository.TowingAirplaneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TowingAirplaneController {

    TowingAirplaneRepository towingAirplaneRepository;

    @Autowired
    public TowingAirplaneController(TowingAirplaneRepository towingAirplaneRepository) {
        this.towingAirplaneRepository = towingAirplaneRepository;
    }



}

