package com.gympulse.gympulse.model.person;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor //generate m no-argument constructor fot the class
@AllArgsConstructor // generate ca construct with all class fields as parameters
@Data // generate getters, setters, toString, equals , and hasgcode methods
public abstract class Person {
    private  String fullName ; //the full name of person
    private String email; // email address of the person
    private String address; // physical address of the person
    private String PhoneNumber; // contact phonenumber of the person
}
