package com.gympulse.gympulse.repositories;

import com.gympulse.gympulse.model.feedback.Feedback;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface FeedbackRepository extends MongoRepository<Feedback, String> {
    List<Feedback> findByTrainerId(String trainerId);
    List<Feedback> findByMemberId(String memberId);
}
