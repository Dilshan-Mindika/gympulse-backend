package com.nexus.GYMPULSE.model.workoutplan.strategies;

import java.util.List;
import com.nexus.GYMPULSE.model.workoutplan.DailyWorkout;

// Interface representing a strategy for generating workout routines
public interface WorkoutStrategy {

    // Method to generate a list of DailyWorkout instances representing a workout routine
    List<DailyWorkout> generateRoutine();
}
