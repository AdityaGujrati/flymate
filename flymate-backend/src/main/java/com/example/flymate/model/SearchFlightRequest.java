package com.example.flymate.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SearchFlightRequest {
    public String departureAirport;
    public String arrivalAirport;
}
