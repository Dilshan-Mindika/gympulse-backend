package com.nexus.GYMPULSE.requests;

import com.nexus.GYMPULSE.model.workoutplan.WorkoutPlan;
import lombok.Data;

// Request object for creating or updating a Member
@Data
public class MemberRequest {
    private String memberId; // Unique identifier for the member
    private String memberShipType; // Type of membership (e.g., basic, premium)
    private String startDate; // Membership start date
    private String endDate; // Membership end date
    private WorkoutPlan workoutPlan; // Workout plan associated with the member
    private String fullName; // Full name of the member
    private String email; // Email address of the member
    private String address; // Residential address of the member
    private String phoneNumber; // Contact phone number of the member
}
