package com.codecool.gaborkallos.glidertowing.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Arrays;
import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Glider {

    @Id
    @GeneratedValue
    private Long id;
    private String registrationNumber;
    private String raceNumber;
    private String pilotName;
    private Category category;
    private boolean isFlying;


    public List<Category> categories(){
        return Arrays.asList(Category.values());
    }


}
