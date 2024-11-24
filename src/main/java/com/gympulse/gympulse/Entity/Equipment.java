package com.gympulse.gympulse.Entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Setter
@Getter
@Document(collection = "equipments")

public class Equipment {

    // Getters and Setters
    @Id
    private String _id;
    private String equipmenttype;
    private String equipmentbrand;
    private String statuses;

    // Constructor with fields
    public Equipment(String _id, String equipmenttype, String equipmentbrand, String statuses) {
        this._id = _id;
        this.equipmenttype = equipmenttype;
        this.equipmentbrand = equipmentbrand;
        this.statuses = statuses;
    }

    // Default constructor
    public Equipment() {
    }

    // Override toString() for debugging
    @Override
    public String toString() {
        return "Equipment{" +
                "_id='" + _id + '\'' +
                ", equipmenttype='" + equipmenttype + '\'' +
                ", equipmentbrand='" + equipmentbrand + '\'' +
                ", statuses='" + statuses + '\'' +
                '}';
    }

}
