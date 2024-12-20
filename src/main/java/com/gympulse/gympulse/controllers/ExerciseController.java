package com.gympulse.gympulse.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.gympulse.gympulse.model.workoutplan.Exercise;
import com.gympulse.gympulse.requests.ExerciseRequest;
import com.gympulse.gympulse.service.interfaces.ExerciseService;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/Exercises") // Base URL for Exercise endpoints
public class ExerciseController {

    @Autowired
    private ExerciseService exerciseService; // Injecting the ExerciseService for business logic

    // Endpoint to retrieve all exercises
    @GetMapping()
    public ResponseEntity<List<Exercise>> getAllExercises() {
        return new ResponseEntity<List<Exercise>>(exerciseService.allExercises(), HttpStatus.OK); // Return all exercises with OK status
    }

    // Endpoint to create a new exercise
    @PostMapping()
    public Exercise createExercise(@RequestBody ExerciseRequest exerciseRequest) {
        // Extracting exercise details from the request
        String name = exerciseRequest.getName();
        Integer quantitySets = exerciseRequest.getQuantitySets();
        Integer quantityReps = exerciseRequest.getQuantityReps();
        Integer resTimeSeconds = exerciseRequest.getResTimeSeconds();

        // Creating and returning the new exercise
        return exerciseService.createExercise(name, quantitySets, quantityReps, resTimeSeconds);
    }

    // Endpoint to retrieve a specific exercise by its ID
    @GetMapping("/{id}")
    public ResponseEntity<Optional<Exercise>> getExerciseById(@PathVariable String id) {
        return new ResponseEntity<Optional<Exercise>>(exerciseService.exerciseById(id), HttpStatus.OK); // Return exercise by ID
    }

    // Endpoint to update an existing exercise by its ID
    @PutMapping("/{id}")
    public Exercise updateExercise(@PathVariable String id, @RequestBody ExerciseRequest exerciseRequest) {
        return exerciseService.updateExercise(id, exerciseRequest); // Update and return the modified exercise
    }

    // Endpoint to clone an existing exercise by its ID
    @PostMapping("/{id}/clone")
    public Exercise cloneExercise(@PathVariable String id) {
        return exerciseService.cloneExercise(id); // Clone and return the exercise
    }

    // Endpoint to delete an exercise by its ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteExercise(@PathVariable String id) {
        exerciseService.deleteExerciseById(id); // Delete the exercise
        return new ResponseEntity<>(HttpStatus.NO_CONTENT); // Return no content response
    }
}
