package com.codecool.gaborkallos.glidertowing.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.Period;

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

    public void setPrice(Flight flight) {

        long diff = Duration.between(flight.takeOffTime, flight.LandingTime).toMinutes();
        if (flight.getGlider().getCategory().equals(Category.WITHWATERBALLAST)) {
            this.price = 1600L*diff;
        } else if (flight.getGlider().getCategory().equals(Category.WITHOUTWATERBALLAST)) {
            this.price = 1400L*diff;
        }
    }
}
