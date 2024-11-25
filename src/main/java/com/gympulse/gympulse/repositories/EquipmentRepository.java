package com.gympulse.gympulse.repositories;

import com.gympulse.gympulse.model.equipment.Equipment;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EquipmentRepository extends MongoRepository<Equipment, ObjectId> {
    Optional<Equipment> findById(String id);

    boolean existsById(String id);

    void deleteById(String id);
    // Custom query methods can be added here if needed
}
