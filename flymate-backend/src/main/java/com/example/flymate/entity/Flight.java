package com.example.flymate.entity;

import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "flight")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Flight {

    private Integer flightId;
    private Airline airline;
    private String departureAirport;
    private String arrivalAirport;

    private List<Passenger> passengerList;
    private List<Scheduler> schedulerList;

}
