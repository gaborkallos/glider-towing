package com.codecool.gaborkallos.glidertowing.model;


import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Flight {

    @Id
    @GeneratedValue
    private Long id;
    @OneToOne
    private Glider glider;
    @OneToOne
    private TowingAirplane towingAirplane;
    private LocalDateTime takeOffTime;
    private LocalDateTime LandingTime;
    private Long price;

    public Flight(Glider glider, TowingAirplane towingAirplane) {
        this.glider = glider;
        this.towingAirplane = towingAirplane;
        setPrice(glider);
    }

    public void setPrice(Glider glider) {
        if (glider.getCategory().equals(Category.WITHWATERBALLAST)) {
            this.price = 1600L;
        } else if (glider.getCategory().equals(Category.WITHOUTWATERBALLAST)) {
            this.price = 1400L;
        }
    }
}
