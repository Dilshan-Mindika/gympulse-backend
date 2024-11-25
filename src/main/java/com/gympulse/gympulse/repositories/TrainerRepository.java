package com.nexus.GYMPULSE.repositories;

import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.nexus.GYMPULSE.model.person.Trainer;

// Repository interface for managing Trainer entities in MongoDB
@Repository
public interface TrainerRepository extends MongoRepository<Trainer, ObjectId> {
    // Finds a Trainer by their unique trainer ID
    Optional<Trainer> findByTrainerId(String trainerId);
}
