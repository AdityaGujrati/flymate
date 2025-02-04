package com.example.flymate.entity;

import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Document(collection = "airline")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Airline {

    @Id
    private String id;
    private String airLineName;
    private List<Flight> flightList;

    public Airline(String airLineName){
        this.flightList = new ArrayList<>();
        this.airLineName = airLineName;
    }

}
