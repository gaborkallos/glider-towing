package com.codecool.gaborkallos.glidertowing.controller;

import com.codecool.gaborkallos.glidertowing.model.Flight;
import com.codecool.gaborkallos.glidertowing.model.TowingAirplane;
import com.codecool.gaborkallos.glidertowing.service.FlightService;
import com.codecool.gaborkallos.glidertowing.service.GliderService;
import com.codecool.gaborkallos.glidertowing.service.TowingAirplaneService;
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
        if (!gliderService.gliderIsExist(flight.getGlider())) {
            gliderService.save(flight.getGlider());
        }
        TowingAirplane towing = towingAirplaneService.findTowing(flight);
        if(towing!=null){
            flight.setTowingAirplane(towing);
        }else{
            towingAirplaneService.save(flight.getTowingAirplane());
        }
        flightService.save(flight);
    }

}
