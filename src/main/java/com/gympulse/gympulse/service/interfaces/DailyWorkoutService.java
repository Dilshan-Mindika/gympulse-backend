package com.nexus.GYMPULSE.service.interfaces;

import java.util.List;
import java.util.Optional;

import com.nexus.GYMPULSE.model.workoutplan.DailyWorkout;
import com.nexus.GYMPULSE.model.workoutplan.Exercise;
import com.nexus.GYMPULSE.requests.DailyWorkoutRequest;

/**
 * Service interface for managing daily workouts.
 */
public interface DailyWorkoutService {

    /**
     * Creates a new daily workout for a specified day of the week.
     *
     * @param dayOfWeek the day of the week for the workout
     * @param exercises a list of exercises for the workout
     * @return the created DailyWorkout
     */
    DailyWorkout createDailyWorkout(String dayOfWeek, List<Exercise> exercises);

    /**
     * Retrieves all daily workouts.
     *
     * @return a list of all DailyWorkouts
     */
    List<DailyWorkout> allDailyWorkouts();

    Optional<DailyWorkout> dailyWorkoutByDayOfWeek(String dayOfWeek);

    /**
     * Finds a daily workout by its ID.
     *
     * @param id the ID of the daily workout
     * @return an Optional containing the DailyWorkout if found, or empty if not
     */
    Optional<DailyWorkout> dailyWorkoutById(String id);

    /**
     * Finds a daily workout by the day of the week.
     *
     * @param dayOfWeek the day of the week
     * @return an Optional containing the DailyWorkout if found, or empty if not
     */
    Optional<DailyWorkout> findDailyWorkoutByDayOfWeek(String dayOfWeek);

    /**
     * Updates an existing daily workout.
     *
     * @param id the ID of the daily workout to update
     * @param dailyWorkoutRequest the new data for the daily workout
     * @return the updated DailyWorkout
     */
    DailyWorkout updateDailyWorkout(String id, DailyWorkoutRequest dailyWorkoutRequest);

    /**
     * Deletes a daily workout by its ID.
     *
     * @param id the ID of the daily workout to delete
     */
    void deleteDailyWorkout(String id);
}
