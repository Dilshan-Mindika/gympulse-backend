package com.gympulse.gympulse.service.interfaces;

import java.util.List;
import java.util.Optional;

import com.gympulse.gympulse.model.workoutplan.Exercise;
import com.gympulse.gympulse.requests.ExerciseRequest;

/**
 * Service interface for managing exercises.
 */
public interface ExerciseService {

    /**
     * Creates a new exercise.
     *
     * @param name the name of the exercise
     * @param quantitySets the number of sets
     * @param quantityReps the number of repetitions
     * @param resTimeSeconds the rest time in seconds
     * @return the created Exercise
     */
    Exercise createExercise(String name, Integer quantitySets, Integer quantityReps, Integer resTimeSeconds);

    /**
     * Retrieves all exercises.
     *
     * @return a list of all Exercises
     */
    List<Exercise> allExercises();

    /**
     * Finds an exercise by its ID.
     *
     * @param id the ID of the exercise
     * @return an Optional containing the Exercise if found, or empty if not
     */
    Optional<Exercise> findExerciseById(String id);

    Optional<Exercise> exerciseById(String id);

    /**
     * Updates an existing exercise.
     *
     * @param id the ID of the exercise to update
     * @param exerciseRequest the new data for the exercise
     * @return the updated Exercise
     */
    Exercise updateExercise(String id, ExerciseRequest exerciseRequest);

    /**
     * Clones an existing exercise.
     *
     * @param id the ID of the exercise to clone
     * @return the cloned Exercise
     */
    Exercise cloneExercise(String id);

    /**
     * Deletes an exercise by its ID.
     *
     * @param id the ID of the exercise to delete
     */
    void deleteExerciseById(String id);
}
