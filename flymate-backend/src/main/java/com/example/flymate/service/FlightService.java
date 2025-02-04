package com.example.flymate.service;

import com.example.flymate.entity.Airline;
import com.example.flymate.entity.Flight;
import com.example.flymate.entity.Scheduler;
import com.example.flymate.model.CreateFlightRequest;
import com.example.flymate.model.SchedulerRequest;
import com.example.flymate.model.SearchFlightRequest;
import com.example.flymate.repository.AirLineRepository;
import com.example.flymate.repository.FlightRepository;
import com.example.flymate.util.DateUtil;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class FlightService {

    @Autowired
    FlightRepository flightRepository;

    @Autowired
    AirLineRepository  airLineRepository;

    @Transactional
    public Flight createFlight(CreateFlightRequest createFlightRequest){

        Airline airline = airLineRepository.findByAirLineName(createFlightRequest.getAirLineName());
        if(Objects.isNull(airline)) airline = new Airline(createFlightRequest.getAirLineName());
        Flight flight = Flight.builder().airline(Airline.builder()
                .airLineName(createFlightRequest.getAirLineName())
                .build())
                .departureAirport(createFlightRequest.getDepartureAirport())
                .arrivalAirport(createFlightRequest.getArrivalAirport())
                .schedulerList(getSchedulerList(createFlightRequest.getListOfSchedule()))
                .build();
        airline.getFlightList().add(flight);
        airLineRepository.save(airline);
        return flightRepository.save(flight);
    }

    private List<Scheduler> getSchedulerList(List<SchedulerRequest> listOfSchedule) {
       List<Scheduler> schedulerList = new ArrayList<>();
       listOfSchedule.forEach(schedulerRequest -> {
           Scheduler scheduler = Scheduler.builder()
                                   .startTime(DateUtil.convertStringIntoTimestamp(schedulerRequest.getStartTime()))
                                   .endTime(DateUtil.convertStringIntoTimestamp(schedulerRequest.getEndTime()))
                                .build();
           schedulerList.add(scheduler);
       });
       return schedulerList;
    }

    public List<Flight> getAllFlight(SearchFlightRequest searchFlightRequest) {
        return flightRepository.findFlightByDepartureAirportAndArrivalAirport(searchFlightRequest.getDepartureAirport(), searchFlightRequest.getArrivalAirport());
    }
}
