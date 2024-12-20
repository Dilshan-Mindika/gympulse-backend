package com.gympulse.gympulse.service.implementations;

import com.gympulse.gympulse.model.attendance.Attendance;
import com.gympulse.gympulse.repositories.AttendanceRepository;
import com.gympulse.gympulse.requests.AttendanceRequest;
import com.gympulse.gympulse.service.interfaces.AttendanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AttendanceServiceImpl implements AttendanceService {
    @Autowired
    private AttendanceRepository attendanceRepository;

    @Override
    public Attendance recordAttendance(AttendanceRequest attendanceRequest) {
        Attendance attendance = new Attendance();
        attendance.setMemberId(attendanceRequest.getMemberId());
        attendance.setTimeSlotId(attendanceRequest.getTimeSlotId());
        attendance.setDate(attendanceRequest.getDate());
        attendance.setAttended(attendanceRequest.isAttended());
        return attendanceRepository.save(attendance);
    }

    @Override
    public List<Attendance> getAllAttendanceRecords() {
        return attendanceRepository.findAll();
    }

    @Override
    public Optional<Attendance> getAttendanceById(String id) {
        return attendanceRepository.findById(id);
    }

    @Override
    public List<Attendance> getAttendanceByMemberId(String memberId) {
        return attendanceRepository.findByMemberId(memberId);
    }

    @Override
    public List<Attendance> getAttendanceByTimeSlotId(String timeSlotId) {
        return attendanceRepository.findByTimeSlotId(timeSlotId);
    }
}
