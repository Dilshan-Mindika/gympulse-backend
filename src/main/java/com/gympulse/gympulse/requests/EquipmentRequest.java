package com.nexus.GYMPULSE.requests;

import lombok.Data;

@Data
public class EquipmentRequest {
    private String id;           // Unique identifier
    private String name;         // Name of the equipment
    private String type;         // Type of equipment (e.g., Cardio, Strength)
    private String brand;        // Brand of the equipment
    private int quantity;        // Number of units available
    private boolean available;   // Availability status
}
