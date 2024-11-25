package com.nexus.GYMPULSE.requests;

import lombok.Data;

// Request object for creating or updating an Exercise
@Data
public class ExerciseRequest {
    private String name; // Name of the exercise
    private Integer quantitySets; // Number of sets for the exercise
    private Integer quantityReps; // Number of repetitions per set
    private Integer resTimeSeconds; // Rest time in seconds between sets
}
