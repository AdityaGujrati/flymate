package com.example.flymate.controller;

import com.example.flymate.entity.Booking;
import com.example.flymate.model.BookFlightRequest;
import com.example.flymate.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1")
public class BookingController {

    @Autowired
    BookingService bookingService;

    @PostMapping("/book-flight")
    public Booking bookFlight(@RequestBody BookFlightRequest bookFlightRequest){
        return bookingService.bookFlight(bookFlightRequest);
    }

}
