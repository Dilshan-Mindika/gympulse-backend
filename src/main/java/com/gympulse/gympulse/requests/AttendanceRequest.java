package com.nexus.GYMPULSE.requests;

import java.time.LocalDate;

public class AttendanceRequest {
    private String memberId; // ID of the member
    private String timeSlotId; // ID of the time slot
    private LocalDate date; // date of attendance
    private boolean attended; // attendance status

    // Getters and Setters
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
