package com.nexus.GYMPULSE.model.person;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Document(collection = "trainers") // Indicates that this class will be stored in the "trainers" collection in MongoDB
@Data // Generates getters, setters, toString, equals, and hashCode methods
@EqualsAndHashCode(callSuper = true) // Enables equality checks including fields from the superclass
@NoArgsConstructor // Generates a no-argument constructor
@AllArgsConstructor // Generates a constructor with all class fields
public class Trainer extends Person { // Inherits from the Person class
    @Id
    private String trainerId; // Unique identifier for the trainer
    private String speciality; // The trainer's area of expertise (e.g., cardio, strength training)
    private Double salary; // The trainer's salary
    private String certificationNumber; // Certification number of the trainer

    // Constructor for creating a trainer with all fields
    public Trainer(String trainerId, String speciality, Double salary, String certificationNumber,
                   String fullName, String phoneNumber, String address, String email) {
        super(fullName, email, address, phoneNumber); // Initialize fields from the Person superclass
        this.trainerId = trainerId; // Set the unique trainer ID
        this.speciality = speciality; // Set the trainer's speciality
        this.salary = salary; // Set the salary
        this.certificationNumber = certificationNumber; // Set the certification number
    }

    // Constructor for creating a trainer without specifying trainer ID (useful for new trainers)
    public Trainer(String speciality, Double salary, String certificationNumber,
                   String fullName, String phoneNumber, String address, String email) {
        super(fullName, email, address, phoneNumber); // Initialize fields from the Person superclass
        this.certificationNumber = certificationNumber; // Set the certification number
        this.salary = salary; // Set the salary
        this.speciality = speciality; // Set the trainer's speciality
    }
}
