package com.gympulse.gympulse.requests;

import java.util.List;

import com.gympulse.gympulse.model.workoutplan.DailyWorkout;

import lombok.Data;

// Request object for creating or updating a Workout Plan
@Data
public class WorkoutPlanRequest {
    private String id; // Unique identifier for the workout plan
    private String memberId; // ID of the member associated with the workout plan
    private String trainerId; // ID of the trainer overseeing the workout plan
    private String startDate; // Start date of the workout plan
    private String endDate; // End date of the workout plan
    private List<DailyWorkout> dailyWorkouts; // List of daily workouts included in the plan
}
