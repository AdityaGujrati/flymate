package com.example.flymate.model;

import com.example.flymate.enums.Gender;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PassengerRequest {

    private String firstName;
    private String lastName;
    private String aadhaarNumber;
    private Integer age;
    private Gender gender;

}
