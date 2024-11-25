package com.nexus.GYMPULSE.repositories;

import com.nexus.GYMPULSE.model.attendance.Attendance;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface AttendanceRepository extends MongoRepository<Attendance, String> {
    List<Attendance> findByMemberId(String memberId);
    List<Attendance> findByTimeSlotId(String timeSlotId);
}
