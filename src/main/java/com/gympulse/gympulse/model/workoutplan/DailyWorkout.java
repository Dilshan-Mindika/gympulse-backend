package com.nexus.GYMPULSE.model.workoutplan;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

// Represents a daily workout plan for a specific day of the week
@Document(collection = "dailyWorkouts") // Indicates this class maps to a MongoDB collection
@Data
@AllArgsConstructor // Generates a constructor with all parameters
@NoArgsConstructor // Generates a no-argument constructor
public class DailyWorkout {
    @Id
    private String id; // Unique identifier for the daily workout
    private String dayOfWeek; // Day of the week for this workout
    @DocumentReference
    private List<Exercise> exercises; // List of exercises included in this workout

    // Constructor for creating a DailyWorkout with specified day and exercises
    public DailyWorkout(String dayOfWeek, List<Exercise> exercises) {
        this.dayOfWeek = dayOfWeek;
        this.exercises = exercises;
    }
}
