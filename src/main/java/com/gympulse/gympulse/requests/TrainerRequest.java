package com.gympulse.gympulse.requests;

import lombok.Data;

// Request object for creating or updating a Trainer
@Data
public class TrainerRequest {
    private String fullName;
    private String email;
    private String phoneNumber;
    private String address;
    private String trainerId;
    private String speciality;
    private Double salary;
    private String certificationNumber;
}
