package com.gympulse.gympulse.Entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "equipments")

public class Equipment {

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

    // Getters and Setters
    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getEquipmenttype() {
        return equipmenttype;
    }

    public void setEquipmenttype(String equipmenttype) {
        this.equipmenttype = equipmenttype;
    }

    public String getEquipmentbrand() {
        return equipmentbrand;
    }

    public void setEquipmentbrand(String equipmentbrand) {
        this.equipmentbrand = equipmentbrand;
    }

    public String getStatuses() {
        return statuses;
    }

    public void setStatuses(String statuses) {
        this.statuses = statuses;
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
