package com.nexus.GYMPULSE.service.implementations;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nexus.GYMPULSE.model.workoutplan.DailyWorkout;
import com.nexus.GYMPULSE.model.workoutplan.WorkoutPlan;
import com.nexus.GYMPULSE.model.workoutplan.strategies.WorkoutStrategy;
import com.nexus.GYMPULSE.repositories.WorkoutPlanRepository;
import com.nexus.GYMPULSE.requests.WorkoutPlanRequest;
import com.nexus.GYMPULSE.service.interfaces.WorkoutPlanService;
import com.nexus.GYMPULSE.utils.GymLogger;

@Service
public class WorkoutPlanImpl implements WorkoutPlanService {
    private GymLogger logger = GymLogger.getInstance();

    @Autowired
    private WorkoutPlanRepository workoutPlanRepository;

    @Override
    public WorkoutPlan createWorkoutPlan(String memberId, String trainerId, String startDate, String endDate,
                                         List<DailyWorkout> dailyWorkouts) {
        String id = memberId + trainerId; // Unique ID based on member and trainer
        WorkoutPlan workoutPlan = workoutPlanRepository
                .insert(new WorkoutPlan(id, memberId, trainerId, startDate, endDate, dailyWorkouts));
        logger.log("New Workout Plan created, ID: " + id);
        return workoutPlan;
    }

    @Override
    public List<WorkoutPlan> allWorkoutPlans() {
        return workoutPlanRepository.findAll();
    }

    @Override
    public Optional<WorkoutPlan> findWorkoutPlanByTrainerAndMemberId(String trainerId, String memberId) {
        return Optional.empty();
    }

    @Override
    public Optional<WorkoutPlan> findWorkoutPlanById(String id) {
        return workoutPlanRepository.findById(id);
    }

    @Override
    public List<WorkoutPlan> findWorkoutPlansByMemberId(String memberId) {
        return workoutPlanRepository.findAll().stream()
                .filter(workoutPlan -> memberId.equals(workoutPlan.getMemberId()))
                .collect(Collectors.toList());
    }

    @Override
    public Optional<WorkoutPlan> findWorkoutPlanByIds(String trainerId, String memberId) {
        return workoutPlanRepository.findByMemberIdAndTrainerId(memberId, trainerId);
    }

    @Override
    public void deleteByTrainerAndMemberId(String trainerId, String memberId) {
        Optional<WorkoutPlan> workoutplan = workoutPlanRepository.findByMemberIdAndTrainerId(memberId, trainerId);
        if (workoutplan.isPresent()) {
            logger.log("Workout Plan deleted, ID: " + memberId + trainerId);
            workoutPlanRepository.delete(workoutplan.get());
        } else {
            throw new NoSuchElementException("No Workout Plan found for member ID: " + memberId + " and trainer ID: " + trainerId);
        }
    }

    @Override
    public WorkoutPlan updateWorkoutPlan(String id, WorkoutPlanRequest workoutPlanRequest) {
        Optional<WorkoutPlan> optionalWorkoutPlan = workoutPlanRepository.findById(id);
        if (optionalWorkoutPlan.isPresent()) {
            WorkoutPlan workoutPlan = optionalWorkoutPlan.get();
            workoutPlan.setMemberId(workoutPlanRequest.getMemberId());
            workoutPlan.setTrainerId(workoutPlanRequest.getTrainerId());
            workoutPlan.setStartDate(workoutPlanRequest.getStartDate());
            workoutPlan.setEndDate(workoutPlanRequest.getEndDate());
            workoutPlan.setDailyWorkouts(workoutPlanRequest.getDailyWorkouts());
            logger.log("Workout Plan updated, ID: " + id);
            return workoutPlanRepository.save(workoutPlan);
        } else {
            throw new NoSuchElementException("No Workout Plan found for ID: " + id);
        }
    }

    @Override
    public void deleteById(String id) {
        Optional<WorkoutPlan> workoutPlan = workoutPlanRepository.findById(id);
        if (workoutPlan.isPresent()) {
            logger.log("Workout Plan removed, ID: " + id);
            workoutPlanRepository.delete(workoutPlan.get());
        } else {
            throw new NoSuchElementException("No Workout Plan found for ID: " + id);
        }
    }

    @Override
    public void deleteByIds(String trainerId, String memberId) {

    }

    @Override
    public WorkoutPlan createWorkoutPlanWithStrategy(String memberId, String trainerId, String startDate,
                                                     String endDate, WorkoutStrategy strategy) {
        String id = memberId + trainerId; // Unique ID based on member and trainer
        List<DailyWorkout> dailyWorkouts = strategy.generateRoutine();
        WorkoutPlan workoutPlan = workoutPlanRepository
                .insert(new WorkoutPlan(id, memberId, trainerId, startDate, endDate, dailyWorkouts));

        logger.log("Workout Plan with strategy created, ID: " + id);
        return workoutPlan;
    }
}
