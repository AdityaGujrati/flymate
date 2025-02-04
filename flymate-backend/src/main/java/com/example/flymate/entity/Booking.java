package com.example.flymate.entity;


import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document(collection = "booking")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Booking {

    @Id
    private Integer bookingId;
    private String flighId;
    private String passengerId;
    private Date bookingDate;
    private Integer seatNumber;


}
