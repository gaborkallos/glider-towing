package com.codecool.gaborkallos.glidertowing.service;

import com.codecool.gaborkallos.glidertowing.model.Category;
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
    public void setGliderRepository(GliderRepository gliderRepository){
        this.gliderRepository = gliderRepository;
    }


    public boolean gliderIsExist(Glider newGlider) {
        List<Glider> gliders = gliderRepository.findAll();
        for (Glider glider : gliders) {
            if (glider.getRegistrationNumber().equals(newGlider.getRegistrationNumber()) &&
            glider.getPilotName().equals(newGlider.getPilotName())){
                return true;
            }
        }
        return false;
    }

    public List<Category> getCategories(){
        return Arrays.asList(Category.values());
    }

    public void save(Glider newGlider) {
        gliderRepository.save(newGlider);
    }
}
