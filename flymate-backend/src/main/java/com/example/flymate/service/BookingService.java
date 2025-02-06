package com.example.flymate.service;

import com.example.flymate.entity.Booking;
import com.example.flymate.entity.Flight;
import com.example.flymate.entity.Passenger;
import com.example.flymate.entity.Scheduler;
import com.example.flymate.model.BookFlightRequest;
import com.example.flymate.model.PassengerRequest;
import com.example.flymate.repository.BookingRepository;
import com.example.flymate.repository.FlightRepository;
import com.example.flymate.repository.SchedulerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Service
public class BookingService {

    @Autowired
    FlightRepository flightRepository;

    @Autowired
    SchedulerRepository schedulerRepository;

    @Autowired
    BookingRepository bookingRepository;

    public Booking bookFlight(BookFlightRequest bookFlightRequest) {

        Flight flight = flightRepository.findByFlightId(bookFlightRequest.getFlightId());
        if(Objects.isNull(flight)) throw new RuntimeException("flight doesn't exist");
        Scheduler scheduler = schedulerRepository.findBySchedulerId(bookFlightRequest.getSchedulerId());
        if(Objects.isNull(scheduler)) throw new RuntimeException("Scheduler doesn't exist");
        String bookingId = UUID.randomUUID().toString();

        Booking booking = Booking.builder()
                                 .bookingId(bookingId)
                                .bookingDate(LocalDate.now().toString())
                                .flightId(bookFlightRequest.getFlightId())
                                .passengerList(getPassengerList(bookFlightRequest.getPassengerRequestList(),bookingId))
                                .build();
        scheduler.setPassengerList(booking.getPassengerList());
        flightRepository.save(flight);
        schedulerRepository.save(scheduler);
        bookingRepository.save(booking);
        return booking;
    }

    private List<Passenger> getPassengerList(List<PassengerRequest> passengerRequestList, String bookingId) {

        List<Passenger> passengerList = new ArrayList<>();
        passengerRequestList.forEach(passengerRequest -> {
            passengerList.add(Passenger.builder()
                                        .firstName(passengerRequest.getFirstName())
                                        .lastName(passengerRequest.getLastName())
                                        .bookingId(bookingId)
                                        .build());
        });
        return passengerList;
    }
}
