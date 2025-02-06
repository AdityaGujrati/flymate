package com.example.flymate.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SearchFlightResponse {

    private String airlineName;
    private String flightId;
    private String arrivalLocation;
    private String destinationLocation;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private String schedulerId;
}
