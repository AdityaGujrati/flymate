package com.example.flymate.model;

import com.example.flymate.entity.Flight;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CreateFlightRequest {

    private String airLineName;
    private String departureAirport;
    private String arrivalAirport;
    private Integer capacity;
    private String flightId;
    private List<SchedulerRequest> listOfSchedule;

}
