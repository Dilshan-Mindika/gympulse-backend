package com.nexus.GYMPULSE.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.nexus.GYMPULSE.model.workoutplan.WorkoutPlan;
import com.nexus.GYMPULSE.model.workoutplan.strategies.CardioStrategy;
import com.nexus.GYMPULSE.model.workoutplan.strategies.StrengthTrainingStrategy;
import com.nexus.GYMPULSE.model.workoutplan.strategies.WorkoutStrategy;
import com.nexus.GYMPULSE.requests.WorkoutPlanRequest;
import com.nexus.GYMPULSE.service.interfaces.WorkoutPlanService;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/WorkoutPlans") // Base URL for workout plan-related endpoints
public class WorkoutPlanController {

    @Autowired
    private WorkoutPlanService workoutPlanService; // Injecting the WorkoutPlanService to manage workout plan logic

    // Endpoint to retrieve all workout plans
    @GetMapping
    public ResponseEntity<List<WorkoutPlan>> getAllWorkoutPlans() {
        return new ResponseEntity<>(workoutPlanService.allWorkoutPlans(), HttpStatus.OK); // Return all workout plans with OK status
    }

    // Endpoint to retrieve a specific workout plan by ID
    @GetMapping("/{id}")
    public ResponseEntity<Optional<WorkoutPlan>> getWorkoutByIds(@PathVariable String id) {
        return new ResponseEntity<>(workoutPlanService.findWorkoutPlanById(id), HttpStatus.OK); // Return workout plan by ID
    }

    // Endpoint to retrieve workout plans by member ID
    @GetMapping("/member/{memberId}")
    public ResponseEntity<List<WorkoutPlan>> getWorkoutPlansByMemberId(@PathVariable String memberId) {
        return new ResponseEntity<>(workoutPlanService.findWorkoutPlansByMemberId(memberId), HttpStatus.OK); // Return workout plans for the specific member
    }

    // Endpoint to create a new workout plan
    @PostMapping
    public WorkoutPlan createWorkoutPlan(@RequestBody WorkoutPlanRequest workoutPlanRequest) {
        return workoutPlanService.createWorkoutPlan(
                workoutPlanRequest.getMemberId(),
                workoutPlanRequest.getTrainerId(),
                workoutPlanRequest.getStartDate(),
                workoutPlanRequest.getEndDate(),
                workoutPlanRequest.getDailyWorkouts()
        ); // Create and return the new workout plan
    }

    // Endpoint to update an existing workout plan by ID
    @PutMapping("/{id}")
    public WorkoutPlan updateWorkoutPlan(@PathVariable String id, @RequestBody WorkoutPlanRequest workoutPlanRequest) {
        return workoutPlanService.updateWorkoutPlan(id, workoutPlanRequest); // Update and return the modified workout plan
    }

    // Endpoint to delete a workout plan by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteByIds(@PathVariable String id) {
        workoutPlanService.deleteById(id); // Delete the workout plan
        return new ResponseEntity<>(HttpStatus.NO_CONTENT); // Return no content response
    }

    // Endpoint to create a new workout plan with a specific strategy
    @PostMapping("/withStrategy")
    public WorkoutPlan createWorkoutPlanWithStrategy(@RequestBody WorkoutPlanRequest workoutPlanRequest, @RequestParam String strategyType) {
        WorkoutStrategy strategy;
        // Determine the workout strategy based on the request parameter
        switch (strategyType.toLowerCase()) {
            case "cardio":
                strategy = new CardioStrategy(); // Use cardio strategy
                break;
            case "strength":
                strategy = new StrengthTrainingStrategy(); // Use strength training strategy
                break;
            default:
                throw new IllegalArgumentException("Invalid strategy type"); // Handle invalid strategy type
        }
        return workoutPlanService.createWorkoutPlanWithStrategy(
                workoutPlanRequest.getMemberId(),
                workoutPlanRequest.getTrainerId(),
                workoutPlanRequest.getStartDate(),
                workoutPlanRequest.getEndDate(),
                strategy // Create the workout plan with the chosen strategy
        );
    }
}
