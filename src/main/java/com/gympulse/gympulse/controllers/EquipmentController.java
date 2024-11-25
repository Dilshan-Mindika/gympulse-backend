package com.gympulse.gympulse.controllers;

import com.gympulse.gympulse.model.equipment.Equipment;
import com.gympulse.gympulse.service.interfaces.EquipmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/equipment") // Base URL for equipment-related endpoints
public class EquipmentController {

    @Autowired
    private EquipmentService equipmentService;

    @PostMapping
    public Equipment addEquipment(@RequestBody Equipment equipment) {
        return equipmentService.addEquipment(equipment); // Pass the whole equipment object
    }

    @GetMapping
    public ResponseEntity<List<Equipment>> getAllEquipment() {
        List<Equipment> equipmentList = equipmentService.getAllEquipment();
        return ResponseEntity.ok(equipmentList); // Return list of equipment
    }

    @GetMapping("/{id}")
    public ResponseEntity<Equipment> getEquipmentById(@PathVariable String id) {
        Optional<Equipment> equipment = equipmentService.getEquipmentById(id);
        return equipment.map(ResponseEntity::ok) // Return equipment if found
                .orElse(ResponseEntity.notFound().build()); // Return 404 if not found
    }

    @PutMapping("/{id}")
    public ResponseEntity<Equipment> updateEquipment(@PathVariable String id, @RequestBody Equipment equipment) {
        Equipment updatedEquipment = equipmentService.updateEquipment(id, equipment);
        return updatedEquipment != null
                ? ResponseEntity.ok(updatedEquipment) // Return updated equipment
                : ResponseEntity.notFound().build(); // Return 404 if not found
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEquipment(@PathVariable String id) {
        equipmentService.deleteEquipment(id); // Delete equipment
        return ResponseEntity.noContent().build(); // Return 204 No Content
    }
}
