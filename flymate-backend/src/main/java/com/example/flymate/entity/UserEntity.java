package com.example.flymate.entity;


import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.id.factory.internal.AutoGenerationTypeStrategy;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Document(collection = "user")
public class UserEntity {

    @Id
    private Integer userId;
    private String userName;
    private String emailId;
    private String phoneNumber;

}
