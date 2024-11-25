package com.nexus.GYMPULSE.model.person;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor // Generates a no-argument constructor for the class
@AllArgsConstructor // Generates a constructor with all class fields as parameters
@Data // Generates getters, setters, toString, equals, and hashCode methods
public abstract class Person { // Abstract class that cannot be instantiated directly
    private String fullName; // The full name of the person
    private String email; // The email address of the person
    private String address; // The physical address of the person
    private String phoneNumber; // The contact phone number of the person
}
