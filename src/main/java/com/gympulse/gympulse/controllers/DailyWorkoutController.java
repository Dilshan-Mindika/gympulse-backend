package com.nexus.GYMPULSE.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.nexus.GYMPULSE.model.workoutplan.DailyWorkout;
import com.nexus.GYMPULSE.model.workoutplan.Exercise;
import com.nexus.GYMPULSE.requests.DailyWorkoutRequest;
import com.nexus.GYMPULSE.service.interfaces.DailyWorkoutService;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/DailyWorkouts") // Base URL for DailyWorkout endpoints
public class DailyWorkoutController {

    @Autowired
    private DailyWorkoutService dailyWorkoutService; // Injecting the service to handle business logic

    // Endpoint to get all daily workouts
    @GetMapping
    public ResponseEntity<List<DailyWorkout>> getAllDailyWorkouts() {
        return new ResponseEntity<List<DailyWorkout>>(dailyWorkoutService.allDailyWorkouts(), HttpStatus.OK);
    }

    // Endpoint to get a specific daily workout by ID
    @GetMapping("/{id}")
    public ResponseEntity<Optional<DailyWorkout>> getDailyWorkoutById(@PathVariable String id) {
        return new ResponseEntity<Optional<DailyWorkout>>(dailyWorkoutService.dailyWorkoutById(id), HttpStatus.OK);
    }

    // Endpoint to get daily workout by day of the week
    @GetMapping("/day/{dayOfWeek}")
    public ResponseEntity<Optional<DailyWorkout>> getDailyWorkoutByDayOfWeek(@PathVariable String dayOfWeek) {
        return new ResponseEntity<Optional<DailyWorkout>>(dailyWorkoutService.dailyWorkoutByDayOfWeek(dayOfWeek), HttpStatus.OK);
    }

    // Endpoint to create a new daily workout plan
    @PostMapping
    public DailyWorkout createDailyWorkoutPlan(@RequestBody DailyWorkout dailyWorkout) {
        String dayOfWeek = dailyWorkout.getDayOfWeek(); // Get the day of the week from the request
        List<Exercise> exercises = dailyWorkout.getExercises(); // Get the list of exercises
        return dailyWorkoutService.createDailyWorkout(dayOfWeek, exercises); // Create and return the new workout
    }

    // Endpoint to update an existing daily workout by ID
    @PutMapping("/{id}")
    public DailyWorkout updateDailyWorkout(@PathVariable String id, @RequestBody DailyWorkoutRequest dailyWorkoutRequest) {
        return dailyWorkoutService.updateDailyWorkout(id, dailyWorkoutRequest); // Update and return the updated workout
    }

    // Endpoint to delete a daily workout by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDailyWorkout(@PathVariable String id) {
        dailyWorkoutService.deleteDailyWorkout(id); // Delete the workout
        return new ResponseEntity<>(HttpStatus.NO_CONTENT); // Return no content response
    }
}
