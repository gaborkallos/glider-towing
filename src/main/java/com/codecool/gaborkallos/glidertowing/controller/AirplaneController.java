package com.codecool.gaborkallos.glidertowing.controller;

import com.codecool.gaborkallos.glidertowing.model.Flight;
import com.codecool.gaborkallos.glidertowing.service.FlightService;
import com.codecool.gaborkallos.glidertowing.service.GliderService;
import com.codecool.gaborkallos.glidertowing.service.TowingAirplaneService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class AirplaneController {

    private GliderService gliderService;
    private TowingAirplaneService towingAirplaneService;
    private FlightService flightService;

    private static final Logger logger = LoggerFactory.getLogger(FlightController.class);

    @Autowired
    public void setFlightService(FlightService flightService) {
        this.flightService = flightService;
    }

    @Autowired
    public void setGliderService(GliderService gliderService) {
        this.gliderService = gliderService;
    }

    @Autowired
    public void setTowingAirplaneService(TowingAirplaneService towingAirplaneService) {
        this.towingAirplaneService = towingAirplaneService;
    }

    @RequestMapping(value = "/airplane", method = RequestMethod.POST)
    public void addFlight(@RequestBody Flight flight) {
        gliderService.save(flight.getGlider());
        towingAirplaneService.save(flight.getTowingAirplane());
        flightService.save(flight);


    }

}
