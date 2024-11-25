package com.gympulse.gympulse.model.workoutplan.strategies;

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

import com.gympulse.gympulse.model.workoutplan.DailyWorkout;
import com.gympulse.gympulse.model.workoutplan.Exercise;

// Implementation of the WorkoutStrategy interface for a strength training workout routine
public class StrengthTrainingStrategy implements WorkoutStrategy {

    // Method to generate a strength training workout routine for the week
    @Override
    public List<DailyWorkout> generateRoutine() {
        // Define strength training exercises with their parameters (name, sets, reps, rest time in seconds)
        Exercise squat = new Exercise("Squat", 4, 8, 90); // 4 sets of 8 reps with 90 seconds rest
        Exercise deadlift = new Exercise("Deadlift", 3, 6, 120); // 3 sets of 6 reps with 120 seconds rest
        Exercise benchPress = new Exercise("Bench Press", 4, 8, 90); // 4 sets of 8 reps with 90 seconds rest
        Exercise shoulderPress = new Exercise("Shoulder Press", 3, 10, 60); // 3 sets of 10 reps with 60 seconds rest
        Exercise pullUp = new Exercise("Pull Up", 3, 10, 60); // 3 sets of 10 reps with 60 seconds rest
        Exercise bentOverRow = new Exercise("Bent Over Row", 4, 8, 90); // 4 sets of 8 reps with 90 seconds rest

        // Create DailyWorkout instances for specific days of the week
        DailyWorkout monday = new DailyWorkout("Monday", Arrays.asList(squat, benchPress)); // Strength training on Monday
        DailyWorkout wednesday = new DailyWorkout("Wednesday", Arrays.asList(deadlift, pullUp)); // Strength training on Wednesday
        DailyWorkout friday = new DailyWorkout("Friday", Arrays.asList(shoulderPress, bentOverRow)); // Strength training on Friday

        // Create a list to hold the weekly routine
        List<DailyWorkout> weeklyRoutine = new ArrayList<>();
        weeklyRoutine.add(monday); // Add Monday's workout
        weeklyRoutine.add(wednesday); // Add Wednesday's workout
        weeklyRoutine.add(friday); // Add Friday's workout

        return weeklyRoutine; // Return the complete weekly strength training routine
    }
}
