package com.gympulse.gympulse.model.person;

import org.springframework.data.mongodb.core.mapping.DocumentReference;

public class Member {
    private  String memberId; // unique identifier for the member
    private String memberShipType; // type of membership(standard,premium)
    private String startDate; //membership start date
    private String endDate; // Membership end date
    @DocumentReference //reference to workplan document
    private WorkoutPlan workoutPlan; // associated workout plan for the member

    //Constructor for creating a member with a workout plan
    public Member (String fullName,String email, String address, String phoneNumber, String memberId,
                   String memberShipType, String startString, String endString ,WorkoutPlan workoutPlan ) {
        super(fullName, email, address, phoneNumber); // Initialize fields from the Person superclass
        this.memberId = memberId; //initialize member-specific fields
        this.memberShipType = memberShipType;
        this.startDate = startString;
        this.workoutPlan = workoutPlan; // set the workout plan

    }




}
