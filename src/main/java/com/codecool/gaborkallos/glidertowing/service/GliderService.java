package com.codecool.gaborkallos.glidertowing.service;

import com.codecool.gaborkallos.glidertowing.model.Category;
import com.codecool.gaborkallos.glidertowing.model.Flight;
import com.codecool.gaborkallos.glidertowing.model.Glider;
import com.codecool.gaborkallos.glidertowing.repository.GliderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;


@Service
public class GliderService {
    private GliderRepository gliderRepository;


    @Autowired
    public void setGliderRepository(GliderRepository gliderRepository) {
        this.gliderRepository = gliderRepository;
    }


    public boolean isGliderExists(Glider newGlider) {
        List<Glider> gliders = gliderRepository.findAll();
        for (Glider glider : gliders) {
            if (glider.getRegistrationNumber().equals(newGlider.getRegistrationNumber())) {
                return true;
            }
        }
        return false;
    }

    public Glider findGlider(Flight flight) {
        if (isGliderExists(flight.getGlider())) {
            List<Glider> all = gliderRepository.findAll();
            for (Glider glider : all) {
                if (glider.getRegistrationNumber().equals(flight.getGlider().getRegistrationNumber())) {
                    return glider;
                }
            }

        }
        return null;
    }

    public List<Category> getCategories() {
        return Arrays.asList(Category.values());
    }

    public void save(Glider newGlider) {
        gliderRepository.save(newGlider);
    }
}
