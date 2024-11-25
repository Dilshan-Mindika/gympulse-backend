package com.gympulse.gympulse.Repo;


import com.gympulse.gympulse.Entity.Equipment;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface EquipmentRepo extends MongoRepository<Equipment,String> {
}
