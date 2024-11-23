package com.nexus.GYMPULSE.model.workoutplan.strategies;

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

import com.nexus.GYMPULSE.model.workoutplan.DailyWorkout;
import com.nexus.GYMPULSE.model.workoutplan.Exercise;

// WorkoutStrategy interface for a cardio workout routine
public class CardioStrategy implements WorkoutStrategy {

    // Method to generate a cardio workout routine for the week
    @Override
    public List<DailyWorkout> generateRoutine() {
		
        // Define cardio exercises with their parameters (name, sets, reps, duration in seconds)
        Exercise running = new Exercise("Running", 1, 1, 1800); // 30 minutes
        Exercise cycling = new Exercise("Cycling", 1, 1, 2400); // 40 minutes
        Exercise swimming = new Exercise("Swimming", 1, 1, 1500); // 25 minutes
        Exercise jumpRope = new Exercise("Jump Rope", 10, 1, 60); // 10 sets of 1 minute
        Exercise rowing = new Exercise("Rowing", 1, 1, 1800); // 30 minutes

        // Create DailyWorkout instances for specific days of the week
        DailyWorkout monday = new DailyWorkout("Monday", Arrays.asList(running)); // Cardio on Monday
        DailyWorkout wednesday = new DailyWorkout("Wednesday", Arrays.asList(cycling, jumpRope)); // Cardio on Wednesday
        DailyWorkout friday = new DailyWorkout("Friday", Arrays.asList(swimming, rowing)); // Cardio on Friday

        // Create a list to hold the weekly routine
        List<DailyWorkout> weeklyRoutine = new ArrayList<>();
        weeklyRoutine.add(monday); // Add Monday's workout
        weeklyRoutine.add(wednesday); // Add Wednesday's workout
        weeklyRoutine.add(friday); // Add Friday's workout

        return weeklyRoutine; // Return the complete weekly cardio routine
    }
}
