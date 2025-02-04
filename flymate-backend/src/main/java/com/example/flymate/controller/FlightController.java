package com.example.flymate.controller;
import com.example.flymate.entity.Flight;
import com.example.flymate.model.CreateFlightRequest;
import com.example.flymate.model.SearchFlightRequest;
import com.example.flymate.service.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/")
public class FlightController {

    @Autowired
    FlightService flightService;

    @PostMapping("/add-flight")
    public Flight createFlight(@RequestBody CreateFlightRequest createFlightRequest){
        return flightService.createFlight(createFlightRequest);
    }

    @PostMapping("/search-flight")
    public List<Flight> getAllFlight(@RequestBody SearchFlightRequest searchFlightRequest){
        return flightService.getAllFlight(searchFlightRequest);
    }


}
