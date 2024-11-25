package com.nexus.GYMPULSE.repositories;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.nexus.GYMPULSE.model.workoutplan.WorkoutPlan;

// Repository interface for managing WorkoutPlan entities
@Repository
public interface WorkoutPlanRepository extends MongoRepository<WorkoutPlan, String> {
    // Finds a WorkoutPlan by associated member ID and trainer ID
    Optional<WorkoutPlan> findByMemberIdAndTrainerId(String memberId, String trainerId);
}
