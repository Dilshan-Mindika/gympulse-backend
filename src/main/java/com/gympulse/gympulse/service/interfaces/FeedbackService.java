package com.nexus.GYMPULSE.service.interfaces;

import com.nexus.GYMPULSE.model.feedback.Feedback;
import com.nexus.GYMPULSE.requests.FeedbackRequest;

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
