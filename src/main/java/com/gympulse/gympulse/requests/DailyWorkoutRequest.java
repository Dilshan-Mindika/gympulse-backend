package com.nexus.GYMPULSE.requests;

import java.util.List;

import com.nexus.GYMPULSE.model.workoutplan.Exercise;

import lombok.Data;

// Request object for creating or updating a DailyWorkout
@Data
public class DailyWorkoutRequest {
    private String id; // Unique identifier for the DailyWorkout
    private String dayOfWeek; // Day of the week for the workout
    private List<Exercise> exercises; // List of exercises included in the workout
}
