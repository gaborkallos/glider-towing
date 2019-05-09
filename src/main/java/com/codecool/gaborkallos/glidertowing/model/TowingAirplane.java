package com.codecool.gaborkallos.glidertowing.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class TowingAirplane {

    @Id
    @GeneratedValue
    private Long id;
    private String registrationNumber;
    private boolean isFlying;


}
