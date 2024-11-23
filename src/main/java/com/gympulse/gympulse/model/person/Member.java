package com.gympulse.gympulse.model.person;

import org.springframework.data.mongodb.core.mapping.DocumentReference;

public class Member {
    private  String memberId; // unique identifier for the member
    private String memberShipType; // type of membership(standard,premium)
    private String startDate; //membership start date
    private String endDate; // Membership end date
    @DocumentReference //reference to workplan document
    private WorkoutPlan workoutPlan; // associated workout plan for the member


}
