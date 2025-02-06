package com.example.flymate.repository;

import com.example.flymate.entity.Scheduler;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SchedulerRepository extends MongoRepository<Scheduler,Integer> {

    List<Scheduler> findSchedulerByDepartureAirportAndArrivalAirport(String departureAirport, String ArrivalAirport);
    Scheduler findBySchedulerId(String schedulerId);

}
