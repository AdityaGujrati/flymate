package com.example.flymate.repository;


import com.example.flymate.entity.Flight;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FlightRepository extends MongoRepository<Flight , Integer> {

    List<Flight> findFlightByDepartureAirportAndArrivalAirport(String departureAirport,String ArrivalAirport);

}
