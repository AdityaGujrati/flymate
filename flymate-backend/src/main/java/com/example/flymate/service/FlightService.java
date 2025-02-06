package com.example.flymate.service;

import com.example.flymate.entity.Airline;
import com.example.flymate.entity.Flight;
import com.example.flymate.entity.Scheduler;
import com.example.flymate.model.CreateFlightRequest;
import com.example.flymate.model.SchedulerRequest;
import com.example.flymate.model.SearchFlightRequest;
import com.example.flymate.model.SearchFlightResponse;
import com.example.flymate.repository.AirLineRepository;
import com.example.flymate.repository.FlightRepository;
import com.example.flymate.repository.SchedulerRepository;
import com.example.flymate.util.DateUtil;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Service
public class FlightService {

    @Autowired
    FlightRepository flightRepository;

    @Autowired
    AirLineRepository  airLineRepository;

    @Autowired
    SchedulerRepository schedulerRepository;

    @Transactional
    public Flight createFlight(CreateFlightRequest createFlightRequest){

        Airline airline = airLineRepository.findByAirLineName(createFlightRequest.getAirLineName());
        if(Objects.isNull(airline)) airline = new Airline(createFlightRequest.getAirLineName());
        Flight flight = Flight.builder().airline(Airline.builder()
                .airLineName(createFlightRequest.getAirLineName())
                .build())
                .flightId(createFlightRequest.getFlightId())
                .schedulerList(getSchedulerList(createFlightRequest.getListOfSchedule(),createFlightRequest.getFlightId()))
                .build();
        airline.getFlightList().add(flight);
        airLineRepository.save(airline);
        schedulerRepository.saveAll(flight.getSchedulerList());
        return flightRepository.save(flight);
    }

    private List<Scheduler> getSchedulerList(List<SchedulerRequest> listOfSchedule,String flightId) {
       List<Scheduler> schedulerList = new ArrayList<>();
       listOfSchedule.forEach(schedulerRequest -> {
           Scheduler scheduler = Scheduler.builder()
                                   .schedulerId(UUID.randomUUID().toString())
                                   .startTime(DateUtil.convertStringIntoTimestamp(schedulerRequest.getStartTime()))
                                   .endTime(DateUtil.convertStringIntoTimestamp(schedulerRequest.getEndTime()))
                                   .departureAirport(schedulerRequest.getDepartureAirport())
                                   .arrivalAirport(schedulerRequest.getArrivalAirport())
                                   .flightId(flightId)
                                .build();
           schedulerList.add(scheduler);
       });
       return schedulerList;
    }

    public List<SearchFlightResponse> getAllFlight(SearchFlightRequest searchFlightRequest) {

        List<Scheduler> schedulerByDepartureAirportAndArrivalAirport = schedulerRepository.findSchedulerByDepartureAirportAndArrivalAirport(searchFlightRequest.getDepartureAirport(), searchFlightRequest.getArrivalAirport());
        List<String> flightIds = schedulerByDepartureAirportAndArrivalAirport.stream().map(Scheduler::getFlightId).distinct().toList();
        List<Flight> flightList = flightRepository.findByFlightIdIn(flightIds);
        List<SearchFlightResponse> searchFlightResponseList = new ArrayList<>();
        flightList.forEach(flight -> {
            populateSearchFlightRequestForParticularFlight(searchFlightResponseList,flight,searchFlightRequest);
        });
        return searchFlightResponseList;
    }

    private void populateSearchFlightRequestForParticularFlight(List<SearchFlightResponse> searchFlightResponseList, Flight flight, SearchFlightRequest searchFlightRequest) {
        flight.getSchedulerList().stream().filter(scheduler -> scheduler.getArrivalAirport().equals(searchFlightRequest.getArrivalAirport()) && scheduler.getDepartureAirport().equals(searchFlightRequest.getDepartureAirport()))
                .forEach(scheduler -> {
                    SearchFlightResponse searchFlightResponse = new SearchFlightResponse();
                    searchFlightResponse.setFlightId(flight.getFlightId());
                    searchFlightResponse.setAirlineName(flight.getAirline().getAirLineName());
                    searchFlightResponse.setArrivalLocation(searchFlightRequest.getArrivalAirport());
                    searchFlightResponse.setDestinationLocation(searchFlightRequest.getDepartureAirport());
                    searchFlightResponse.setEndTime(scheduler.getEndTime());
                    searchFlightResponse.setStartTime(scheduler.getStartTime());
                    searchFlightResponse.setSchedulerId(scheduler.getSchedulerId());
                    searchFlightResponseList.add(searchFlightResponse);
                });
    }
}
