package com.nexus.GYMPULSE.model.person;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

import com.nexus.GYMPULSE.model.workoutplan.WorkoutPlan;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Document(collection = "members") // Indicates that this class will be stored in the "members" collection in MongoDB
@Data // Generates getters, setters, toString, equals, and hashCode methods
@EqualsAndHashCode(callSuper = true) // Enables equality checks including fields from the superclass
@NoArgsConstructor // Generates a no-argument constructor
@AllArgsConstructor // Generates a constructor with all class fields
public class Member extends Person { // Inherits from the Person class
    @Id
    private String memberId; // Unique identifier for the member
    private String memberShipType; // Type of membership (e.g., standard, premium)
    private String startDate; // Membership start date
    private String endDate; // Membership end date
    @DocumentReference // Reference to a WorkoutPlan document
    private WorkoutPlan workoutPlan; // Associated workout plan for the member

    // Constructor for creating a member with a workout plan
    public Member(String fullName, String email, String address, String phoneNumber, String memberId,
                  String memberShipType, String startString, String endString, WorkoutPlan workoutPlan) {
        super(fullName, email, address, phoneNumber); // Initialize fields from the Person superclass
        this.memberId = memberId; // Initialize member-specific fields
        this.memberShipType = memberShipType;
        this.startDate = startString;
        this.endDate = endString;
        this.workoutPlan = workoutPlan; // Set the workout plan
    }

    // Constructor for creating a member without a workout plan
    public Member(String fullName, String email, String address, String phoneNumber, String memberId,
                  String memberShipType, String startString, String endString) {
        super(fullName, email, address, phoneNumber); // Initialize fields from the Person superclass
        this.memberId = memberId; // Initialize member-specific fields
        this.memberShipType = memberShipType;
        this.startDate = startString;
        this.endDate = endString;
        this.workoutPlan = null; // No workout plan assigned
    }
}
