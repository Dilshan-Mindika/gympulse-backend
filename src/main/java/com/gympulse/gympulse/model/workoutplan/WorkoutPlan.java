package com.gympulse.gympulse.model.workoutplan;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

import com.gympulse.gympulse.model.workoutplan.strategies.WorkoutStrategy;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

// Represents a workout plan associated with a member and a trainer
@Document(collection = "workoutplans") // Indicates this class maps to a MongoDB collection
@Data
@NoArgsConstructor // Generates a no-argument constructor
@AllArgsConstructor // Generates a constructor with all parameters
public class WorkoutPlan {
    @Id
    private String id; // Unique identifier for the workout plan
    private String memberId; // ID of the member associated with this workout plan
    private String trainerId; // ID of the trainer overseeing the workout plan
    private String startDate; // Start date of the workout plan
    private String endDate; // End date of the workout plan
    @DocumentReference
    private List<DailyWorkout> dailyWorkouts; // List of daily workouts included in the plan
    private WorkoutStrategy workoutStrategy; // Strategy used to generate the workout routine

    // Constructor for creating a WorkoutPlan with specified parameters
    public WorkoutPlan(String id, String memberId, String trainerId, String startDate, String endDate, List<DailyWorkout> dailyWorkouts) {
        this.id = id;
        this.memberId = memberId;
        this.trainerId = trainerId;
        this.startDate = startDate;
        this.endDate = endDate;
        this.dailyWorkouts = dailyWorkouts;
    }

    // Method to generate the workout routine based on the selected strategy
    public void generateRoutine() {
        this.dailyWorkouts = workoutStrategy.generateRoutine(); // Update daily workouts using the strategy
    }
}
