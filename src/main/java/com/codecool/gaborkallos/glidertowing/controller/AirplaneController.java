package com.codecool.gaborkallos.glidertowing.controller;

import com.codecool.gaborkallos.glidertowing.model.Flight;
import com.codecool.gaborkallos.glidertowing.model.Glider;
import com.codecool.gaborkallos.glidertowing.model.Pilot;
import com.codecool.gaborkallos.glidertowing.model.TowingAirplane;
import com.codecool.gaborkallos.glidertowing.service.FlightService;
import com.codecool.gaborkallos.glidertowing.service.GliderService;
import com.codecool.gaborkallos.glidertowing.service.PilotService;
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
    private PilotService pilotService;

    @Autowired
    public void setPilotService(PilotService pilotService) {
        this.pilotService = pilotService;
    }

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

        TowingAirplane towing = towingAirplaneService.findTowing(flight);
        Pilot pilot = pilotService.findPilot(flight);
        Glider glider = gliderService.findGlider(flight);


        if (pilot != null) {
            flight.setGliderPilot(pilot);
        } else {
            pilotService.save(flight.getGliderPilot());
        }

        if (glider != null){
            flight.setGlider(glider);
        }else{
            gliderService.save(flight.getGlider());
        }

        if (towing != null) {
            flight.setTowingAirplane(towing);
        } else {
            towingAirplaneService.save(flight.getTowingAirplane());
        }

        flightService.save(flight);
    }

}
