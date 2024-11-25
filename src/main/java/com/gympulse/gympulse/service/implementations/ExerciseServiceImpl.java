package com.gympulse.gympulse.service.implementations;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gympulse.gympulse.model.workoutplan.Exercise;
import com.gympulse.gympulse.repositories.ExerciseRepository;
import com.gympulse.gympulse.requests.ExerciseRequest;
import com.gympulse.gympulse.service.interfaces.ExerciseService;
import com.gympulse.gympulse.utils.GymLogger;

@Service
public class ExerciseServiceImpl implements ExerciseService {
    private GymLogger logger = GymLogger.getInstance();

    @Autowired
    private ExerciseRepository exerciseRepository;

    @Override
    public Exercise createExercise(String name, Integer quantitySets, Integer quantityReps, Integer resTimeSeconds) {
        // Create a new Exercise and save it to the repository
        Exercise exercise = exerciseRepository.insert(new Exercise(name, quantitySets, quantityReps, resTimeSeconds));
        logger.log("New Exercise created, Name: " + name);
        return exercise;
    }

    @Override
    public List<Exercise> allExercises() {
        // Return a list of all Exercises in the repository
        return exerciseRepository.findAll();
    }

    @Override
    public Optional<Exercise> findExerciseById(String id) {
        return Optional.empty();
    }

    @Override
    public Optional<Exercise> exerciseById(String id) {
        // Retrieve an Exercise by its ID
        return exerciseRepository.findById(id);
    }

    @Override
    public Exercise updateExercise(String id, ExerciseRequest exerciseRequest) {
        // Update an existing Exercise
        Optional<Exercise> optionalExercise = exerciseRepository.findById(id);
        if (optionalExercise.isPresent()) {
            Exercise exercise = optionalExercise.get();
            exercise.setName(exerciseRequest.getName());
            exercise.setQuantityReps(exerciseRequest.getQuantityReps());
            exercise.setQuantitySets(exerciseRequest.getQuantitySets());
            exercise.setResTimeSeconds(exerciseRequest.getResTimeSeconds());
            return exerciseRepository.save(exercise);
        } else {
            throw new NoSuchElementException("Exercise not found for ID: " + id);
        }
    }

    @Override
    public Exercise cloneExercise(String id) {
        // Clone an existing Exercise
        Optional<Exercise> optionalExercise = exerciseRepository.findById(id);
        if (optionalExercise.isPresent()) {
            Exercise original = optionalExercise.get();
            Exercise cloned = original.clone(); // Use the clone method to create a copy
            return exerciseRepository.save(cloned); // Save the cloned exercise
        } else {
            throw new NoSuchElementException("Exercise not found for ID: " + id);
        }
    }

    @Override
    public void deleteExerciseById(String id) {
        // Delete an Exercise by its ID
        Optional<Exercise> exercise = exerciseRepository.findById(id);
        if (exercise.isPresent()) {
            logger.log("Exercise deleted, ID: " + id);
            exerciseRepository.delete(exercise.get());
        } else {
            throw new NoSuchElementException("Exercise not found for ID: " + id);
        }
    }
}
