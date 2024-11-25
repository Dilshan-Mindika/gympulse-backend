package com.nexus.GYMPULSE.requests;

import lombok.Data;

// Request object for creating or updating a Trainer
@Data
public class TrainerRequest {
    private String fullName; // Full name of the trainer
    private String email; // Email address of the trainer
    private String phoneNumber; // Contact phone number of the trainer
    private String address; // Residential address of the trainer
    private String trainerId; // Unique identifier for the trainer
    private String speciality; // Area of expertise (e.g., strength training, yoga)
    private Double salary; // Salary of the trainer
    private String certificationNumber; // Trainer's certification number
}
