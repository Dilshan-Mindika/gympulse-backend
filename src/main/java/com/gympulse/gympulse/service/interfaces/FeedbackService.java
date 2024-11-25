package com.gympulse.gympulse.service.interfaces;

import com.gympulse.gympulse.model.feedback.Feedback;
import com.gympulse.gympulse.requests.FeedbackRequest;

import java.util.List;
import java.util.Optional;

public interface FeedbackService {
    Feedback createFeedback(FeedbackRequest feedbackRequest);
    List<Feedback> getAllFeedbacks();
    Optional<Feedback> getFeedbackById(String id);
    List<Feedback> getFeedbackByTrainerId(String trainerId);
    List<Feedback> getFeedbackByMemberId(String memberId);
    Feedback updateFeedback(String id, FeedbackRequest feedbackRequest);
    void deleteFeedbackById(String id);
}
