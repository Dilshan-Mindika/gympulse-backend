package com.gympulse.gympulse.model.person;

import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "trainers")
@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
AllArgsConstructor
public class Trainer {
    @Id
    private String trainerId;
    private String speciality;
    private Double salary;
    private String certificationNumber;

    // Constructor for creating a trainer with all fields
    public Trainer(String trainerId, String speciality, Double salary, String certificationNumber,
                   )
}
