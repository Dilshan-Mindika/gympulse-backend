package com.nexus.GYMPULSE.repositories;

import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.nexus.GYMPULSE.model.workoutplan.DailyWorkout;

// Repository interface for managing DailyWorkout entities in MongoDB
@Repository
public interface DailyWorkoutRepository extends MongoRepository<DailyWorkout, ObjectId> {
    // Finds a DailyWorkout by its unique identifier
    Optional<DailyWorkout> findDailyWorkoutById(String id);

    // Finds a DailyWorkout by the day of the week
    Optional<DailyWorkout> findDailyWorkoutByDayOfWeek(String dayOfWeek);
}
