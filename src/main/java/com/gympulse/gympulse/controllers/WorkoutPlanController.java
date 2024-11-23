package com.nexus.GYMPULSE.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.nexus.GYMPULSE.model.workoutplan.WorkoutPlan;
import com.nexus.GYMPULSE.model.workoutplan.strategies.CardioStrategy;
import com.nexus.GYMPULSE.model.workoutplan.strategies.StrengthTrainingStrategy;
import com.nexus.GYMPULSE.model.workoutplan.strategies.WorkoutStrategy;
import com.nexus.GYMPULSE.requests.WorkoutPlanRequest;
import com.nexus.GYMPULSE.service.interfaces.WorkoutPlanService;

@RestController
@RequestMapping("/WorkoutPlans") // Base URL for workout plan-related endpoints
public class WorkoutPlanController {

    @Autowired
    private WorkoutPlanService workoutPlanService; // Injecting the WorkoutPlanService to manage workout plan logic

    // retrieve all workout plans
    @GetMapping
    public ResponseEntity<List<WorkoutPlan>> getAllWorkoutPlans() {
        return new ResponseEntity<>(workoutPlanService.allWorkoutPlans(), HttpStatus.OK); // Return all workout plans with OK status
    }

    // retrieve a specific workout plan by ID
    @GetMapping("/{id}")
    public ResponseEntity<Optional<WorkoutPlan>> getWorkoutByIds(@PathVariable String id) {
        return new ResponseEntity<>(workoutPlanService.findWorkoutPlanById(id), HttpStatus.OK); // Return workout plan by ID
    }

    // retrieve workout plans by member ID
    @GetMapping("/member/{memberId}")
    public ResponseEntity<List<WorkoutPlan>> getWorkoutPlansByMemberId(@PathVariable String memberId) {
        return new ResponseEntity<>(workoutPlanService.findWorkoutPlansByMemberId(memberId), HttpStatus.OK); // Return workout plans for the specific member
    }

    // create a new workout plan
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

    // update an existing workout plan by ID
    @PutMapping("/{id}")
    public WorkoutPlan updateWorkoutPlan(@PathVariable String id, @RequestBody WorkoutPlanRequest workoutPlanRequest) {
        return workoutPlanService.updateWorkoutPlan(id, workoutPlanRequest); // Update and return the modified workout plan
    }

    // delete a workout plan by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteByIds(@PathVariable String id) {
        workoutPlanService.deleteById(id); // Delete the workout plan
        return new ResponseEntity<>(HttpStatus.NO_CONTENT); // Return no content response
    }

    // create a new workout plan with a specific strategy
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
