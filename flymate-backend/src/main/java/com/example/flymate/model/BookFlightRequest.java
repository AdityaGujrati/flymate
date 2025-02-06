package com.example.flymate.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookFlightRequest {

    private String flightId;
    private String schedulerId;
    private List<PassengerRequest> passengerRequestList;

}
