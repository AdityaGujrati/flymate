package com.example.flymate.entity;

import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "scheduler")
public class Scheduler {

    @Id
    private Integer schedulerId;
    private LocalDateTime startTime;
    private LocalDateTime endTime;

}
