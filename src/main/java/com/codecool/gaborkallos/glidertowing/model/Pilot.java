package com.codecool.gaborkallos.glidertowing.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Pilot {

    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private boolean isFlying;

}


