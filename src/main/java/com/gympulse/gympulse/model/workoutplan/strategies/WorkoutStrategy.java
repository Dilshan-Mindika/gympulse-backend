package com.nexus.GYMPULSE.model.workoutplan.strategies;

import java.util.List;
import com.nexus.GYMPULSE.model.workoutplan.DailyWorkout;

// Interface for generating workout routines
public interface WorkoutStrategy {

    // Method to generate a list of DailyWorkout a workout routine
    List<DailyWorkout> generateRoutine();
}
