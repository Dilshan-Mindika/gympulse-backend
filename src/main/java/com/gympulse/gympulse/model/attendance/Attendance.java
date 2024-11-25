package com.gympulse.gympulse.model.attendance;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@Document(collection = "attendance")
public class Attendance {
    @Id
    private String id; // unique identifier for each attendance record
    private String memberId; // ID of the member
    private String timeSlotId; // ID of the time slot
    private LocalDate date; // date of attendance
    private boolean attended; // attendance status

    // Constructors
    public Attendance() {}

    public Attendance(String memberId, String timeSlotId, LocalDate date, boolean attended) {
        this.memberId = memberId;
        this.timeSlotId = timeSlotId;
        this.date = date;
        this.attended = attended;
    }

    // Getters and Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMemberId() {
        return memberId;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }

    public String getTimeSlotId() {
        return timeSlotId;
    }

    public void setTimeSlotId(String timeSlotId) {
        this.timeSlotId = timeSlotId;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public boolean isAttended() {
        return attended;
    }

    public void setAttended(boolean attended) {
        this.attended = attended;
    }
}
