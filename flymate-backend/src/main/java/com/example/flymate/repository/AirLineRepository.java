package com.example.flymate.repository;

import com.example.flymate.entity.Airline;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AirLineRepository extends MongoRepository<Airline,String> {

    Airline findByAirLineName(String airLineName);

}
