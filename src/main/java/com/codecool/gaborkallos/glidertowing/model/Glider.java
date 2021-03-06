package com.codecool.gaborkallos.glidertowing.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


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
    private Category category;
    private boolean isFlying;

}
