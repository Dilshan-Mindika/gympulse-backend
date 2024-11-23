package com.nexus.GYMPULSE.model.workoutplan;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

// an exercise with its parameters
@Document(collection = "exercises") // this class maps to a MongoDB collection
@Data
@NoArgsConstructor 
@AllArgsConstructor 
public class Exercise implements Cloneable {
    @Id
    private String id; // identifier for the exercise
    private String name; // Name of exercise
    private Integer quantitySets; // Number of sets for exercise
    private Integer quantityReps; // Number of repetitions 
    private Integer resTimeSeconds; // Rest time between 

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
