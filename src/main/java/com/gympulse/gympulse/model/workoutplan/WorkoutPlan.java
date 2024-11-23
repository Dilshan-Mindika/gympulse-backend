package com.nexus.GYMPULSE.model.workoutplan;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

import com.nexus.GYMPULSE.model.workoutplan.strategies.WorkoutStrategy;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

// a workout plan associated with a member and a trainer
@Document(collection = "workoutplans") // this class maps to a MongoDB collection
@Data
@NoArgsConstructor 
@AllArgsConstructor
public class WorkoutPlan {
    @Id
    private String id; // Unique identifier
    private String memberId; // ID of the member associated 
    private String trainerId; // ID of the trainer overseeing 
    private String startDate; // Start date 
    private String endDate; // End date of 
    @DocumentReference
    private List<DailyWorkout> dailyWorkouts; // List of daily workouts 
    private WorkoutStrategy workoutStrategy; // Strategy used to generate

    // Constructor for creating a WorkoutPlan with specified parameters
    public WorkoutPlan(String id, String memberId, String trainerId, String startDate, String endDate, List<DailyWorkout> dailyWorkouts) {
        this.id = id;
        this.memberId = memberId;
        this.trainerId = trainerId;
        this.startDate = startDate;
        this.endDate = endDate;
        this.dailyWorkouts = dailyWorkouts;
    }

    // generate the workout routine based on the selected strategy
    public void generateRoutine() {
        this.dailyWorkouts = workoutStrategy.generateRoutine(); // Update daily workouts
    }
}
