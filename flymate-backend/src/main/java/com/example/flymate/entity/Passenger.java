package com.example.flymate.entity;

import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "passengers")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Passenger {

    @Id
    private Integer passengerId;
    private String firstName;
    private String lastName;
    private String bookingId;

}
