package com.gympulse.gympulse.service.interfaces;

import com.gympulse.gympulse.model.equipment.Equipment;

import java.util.List;
import java.util.Optional;

public interface EquipmentService {
    Equipment addEquipment(Equipment equipment);           // Add new equipment
    List<Equipment> getAllEquipment();                     // Retrieve all equipment
    Optional<Equipment> getEquipmentById(String id);      // Find equipment by ID
    Equipment updateEquipment(String id, Equipment equipment); // Update equipment details
    void deleteEquipment(String id);                        // Delete equipment by ID
}
