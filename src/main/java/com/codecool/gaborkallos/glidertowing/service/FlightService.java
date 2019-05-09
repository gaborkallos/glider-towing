package com.codecool.gaborkallos.glidertowing.service;

import com.codecool.gaborkallos.glidertowing.model.Flight;
import com.codecool.gaborkallos.glidertowing.repository.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class FlightService {

    FlightRepository flightRepository;

    @Autowired
    public FlightService(FlightRepository flightRepository) {
        this.flightRepository = flightRepository;
    }

    public void update(int id) {
        List<Flight> flights = flightRepository.findAll();
        for (Flight flight : flights) {
            if (flight.getId() == (id)) {

                if (flight.getTakeOffTime() == null &&
                        !flight.getGlider().isFlying() &&
                        !flight.getTowingAirplane().isFlying() &&
                        !flight.getGliderPilot().isFlying()
                ) {
                    flight.getGliderPilot().setFlying(true);
                    flight.getGlider().setFlying(true);
                    flight.getTowingAirplane().setFlying(true);
                    flight.setTakeOffTime(LocalDateTime.now());
                    flightRepository.save(flight);
                    break;
                } else if (flight.getTakeOffTime() != null) {
                    flight.getGliderPilot().setFlying(false);
                    flight.getGlider().setFlying(false);
                    flight.getTowingAirplane().setFlying(false);
                    flight.setLandingTime(LocalDateTime.now());
                    flight.setPrice(flight);
                    flightRepository.save(flight);
                    break;
                } else {
                    //TODO: error handling
                }
            }
        }
    }

    public List<Flight> allFlights() {
        return flightRepository.findAll();
    }

    public void save(Flight flight) {
        flightRepository.save(flight);
    }
}
