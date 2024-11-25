package com.gympulse.gympulse.service.implementations;

import com.gympulse.gympulse.model.equipment.Equipment;
import com.gympulse.gympulse.repositories.EquipmentRepository;
import com.gympulse.gympulse.service.interfaces.EquipmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EquipmentServiceImpl implements EquipmentService {

    @Autowired
    private EquipmentRepository equipmentRepository;

    @Override
    public Equipment addEquipment(Equipment equipment) {
        return equipmentRepository.save(equipment); // Save new equipment
    }

    @Override
    public List<Equipment> getAllEquipment() {
        return equipmentRepository.findAll(); // Retrieve all equipment
    }

    @Override
    public Optional<Equipment> getEquipmentById(String id) {
        return equipmentRepository.findById(id); // Find equipment by ID
    }

    @Override
    public Equipment updateEquipment(String id, Equipment equipment) {
        // Check if equipment exists
        if (equipmentRepository.existsById(id)) {
            equipment.setId(id); // Set the ID to the existing one
            return equipmentRepository.save(equipment); // Update equipment
        }
        return null; // Return null if equipment doesn't exist
    }

    @Override
    public void deleteEquipment(String id) {
        equipmentRepository.deleteById(id); // Delete equipment by ID
    }
}
