package com.gympulse.gympulse.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public abstract class Person {
    private String fullName;
    private String email;
    private String address;
    private String phoneNumber;
}
