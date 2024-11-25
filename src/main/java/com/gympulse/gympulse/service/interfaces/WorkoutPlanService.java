package com.gympulse.gympulse.service.interfaces;

import java.util.List;
import java.util.Optional;

import com.gympulse.gympulse.model.workoutplan.DailyWorkout;
import com.gympulse.gympulse.model.workoutplan.WorkoutPlan;
import com.gympulse.gympulse.requests.WorkoutPlanRequest;
import com.gympulse.gympulse.model.workoutplan.strategies.WorkoutStrategy;

/**
 * Service interface for managing workout plans.
 */
public interface WorkoutPlanService {

    WorkoutPlan createWorkoutPlan(String memberId, String trainerId, String startDate, String endDate, List<DailyWorkout> dailyWorkouts);

    List<WorkoutPlan> allWorkoutPlans();

    Optional<WorkoutPlan> findWorkoutPlanByTrainerAndMemberId(String trainerId, String memberId);

    Optional<WorkoutPlan> findWorkoutPlanById(String id);

    List<WorkoutPlan> findWorkoutPlansByMemberId(String memberId);

    Optional<WorkoutPlan> findWorkoutPlanByIds(String trainerId, String memberId);

    void deleteByTrainerAndMemberId(String trainerId, String memberId);

    WorkoutPlan updateWorkoutPlan(String id, WorkoutPlanRequest workoutPlanRequest);

    void deleteById(String id);

    void deleteByIds(String trainerId, String memberId);

    WorkoutPlan createWorkoutPlanWithStrategy(String memberId, String trainerId, String startDate, String endDate, WorkoutStrategy strategy);
}
