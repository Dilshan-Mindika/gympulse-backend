package com.gympulse.gympulse.repositories;

import com.gympulse.gympulse.model.person.Trainer;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TrainerRepository extends MongoRepository<Trainer, ObjectId> {
    Optional<Trainer> findByTrainerID(String trainerId)
}
