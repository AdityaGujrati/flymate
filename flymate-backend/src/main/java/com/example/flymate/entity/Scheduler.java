package com.example.flymate.entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "scheduler")
public class Scheduler {

    @Id
    private String schedulerId;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private String departureAirport;
    private String arrivalAirport;
    private String flightId;
    private List<Passenger> passengerList;

}
