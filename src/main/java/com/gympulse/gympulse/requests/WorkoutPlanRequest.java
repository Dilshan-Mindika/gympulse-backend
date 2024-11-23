package com.nexus.GYMPULSE.requests;

import java.util.List;

import com.nexus.GYMPULSE.model.workoutplan.DailyWorkout;

import lombok.Data;

// Request object for creating or updating a Workout Plan
@Data
public class WorkoutPlanRequest {
    private String id; // identifier for the workout plan
    private String memberId; // ID of the member associated 
    private String trainerId; // ID of the trainer overseeing
    private String startDate; // Start date 
    private String endDate; // End date
    private List<DailyWorkout> dailyWorkouts; // List of daily workouts included in the plan
}
