package com.nexus.GYMPULSE.service.interfaces;

import com.nexus.GYMPULSE.model.attendance.Attendance;
import com.nexus.GYMPULSE.requests.AttendanceRequest;

import java.util.List;
import java.util.Optional;

public interface AttendanceService {
    Attendance recordAttendance(AttendanceRequest attendanceRequest);
    List<Attendance> getAllAttendanceRecords();
    Optional<Attendance> getAttendanceById(String id);
    List<Attendance> getAttendanceByMemberId(String memberId);
    List<Attendance> getAttendanceByTimeSlotId(String timeSlotId);
}
