package com.nexus.GYMPULSE.repositories;

import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.nexus.GYMPULSE.model.workoutplan.DailyWorkout;

// Repository interface for managing DailyWorkout entities 
@Repository
public interface DailyWorkoutRepository extends MongoRepository<DailyWorkout, ObjectId> {
    // Finds a DailyWorkout by unique identifier
    Optional<DailyWorkout> findDailyWorkoutById(String id);

    // Finds a DailyWorkout by day of the week
    Optional<DailyWorkout> findDailyWorkoutByDayOfWeek(String dayOfWeek);
}
