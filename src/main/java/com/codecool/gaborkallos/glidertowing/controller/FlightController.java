package com.codecool.gaborkallos.glidertowing.controller;

import com.codecool.gaborkallos.glidertowing.model.Category;
import com.codecool.gaborkallos.glidertowing.model.Flight;
import com.codecool.gaborkallos.glidertowing.service.FlightService;
import com.codecool.gaborkallos.glidertowing.service.GliderService;
import com.codecool.gaborkallos.glidertowing.service.TowingAirplaneService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Controller
public class FlightController {

    private static final Logger logger = LoggerFactory.getLogger(FlightController.class);

    private FlightService flightService;
    private GliderService gliderService;
    private TowingAirplaneService towingAirplaneService;


    @Autowired
    public void setFlightService(FlightService flightService) {
        this.flightService = flightService;
    }

    @Autowired
    public void setTowingAirplaneService(TowingAirplaneService towingAirplaneService) {
        this.towingAirplaneService = towingAirplaneService;
    }

    @Autowired
    public void setGliderService(GliderService gliderService) {
        this.gliderService = gliderService;
    }

    @GetMapping("/")
    public String index(Model model) {
        List<Flight> flights = flightService.allFlights();
        List<Category> categories = gliderService.getCategories();
        model.addAttribute("flights", flights);
        model.addAttribute("categories", categories);
        return "index";
    }


    @PutMapping("/")
    public String updateFlights(int id){
        flightService.update(id);
        System.out.println(id);
        return "index";
    }


}

