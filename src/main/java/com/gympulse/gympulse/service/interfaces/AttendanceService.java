package com.gympulse.gympulse.service.interfaces;

import com.gympulse.gympulse.model.attendance.Attendance;
import com.gympulse.gympulse.requests.AttendanceRequest;

import java.util.List;
import java.util.Optional;

public interface AttendanceService {
    Attendance recordAttendance(AttendanceRequest attendanceRequest);
    List<Attendance> getAllAttendanceRecords();
    Optional<Attendance> getAttendanceById(String id);
    List<Attendance> getAttendanceByMemberId(String memberId);
    List<Attendance> getAttendanceByTimeSlotId(String timeSlotId);
}
