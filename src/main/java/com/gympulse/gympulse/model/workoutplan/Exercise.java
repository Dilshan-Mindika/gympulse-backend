package com.nexus.GYMPULSE.model.workoutplan;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

// Represents an exercise with its parameters
@Document(collection = "exercises") // Indicates this class maps to a MongoDB collection
@Data
@NoArgsConstructor // Generates a no-argument constructor
@AllArgsConstructor // Generates a constructor with all parameters
public class Exercise implements Cloneable {
    @Id
    private String id; // Unique identifier for the exercise
    private String name; // Name of the exercise
    private Integer quantitySets; // Number of sets for the exercise
    private Integer quantityReps; // Number of repetitions for each set
    private Integer resTimeSeconds; // Rest time in seconds between sets

    // Constructor for creating an Exercise with specified parameters
    public Exercise(String name, Integer quantitySets, Integer quantityReps, Integer resTimeSeconds) {
        this.name = name;
        this.quantityReps = quantityReps;
        this.quantitySets = quantitySets;
        this.resTimeSeconds = resTimeSeconds;
    }

    // Method to create a copy of the Exercise object
    @Override
    public Exercise clone() {
        try {
            return (Exercise) super.clone(); // Clone the object
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException("Cloning failed", e); // Handle the exception
        }
    }
}
