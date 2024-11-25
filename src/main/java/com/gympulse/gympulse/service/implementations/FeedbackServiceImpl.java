package com.nexus.GYMPULSE.service.implementations;

import com.nexus.GYMPULSE.model.feedback.Feedback;
import com.nexus.GYMPULSE.repositories.FeedbackRepository;
import com.nexus.GYMPULSE.requests.FeedbackRequest;
import com.nexus.GYMPULSE.service.interfaces.FeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class FeedbackServiceImpl implements FeedbackService {
    @Autowired
    private FeedbackRepository feedbackRepository;

    @Override
    public Feedback createFeedback(FeedbackRequest feedbackRequest) {
        Feedback feedback = new Feedback();
        feedback.setMemberId(feedbackRequest.getMemberId());
        feedback.setTrainerId(feedbackRequest.getTrainerId());
        feedback.setComments(feedbackRequest.getComments());
        feedback.setRating(feedbackRequest.getRating());
        return feedbackRepository.save(feedback);
    }

    @Override
    public List<Feedback> getAllFeedbacks() {
        return feedbackRepository.findAll();
    }

    @Override
    public Optional<Feedback> getFeedbackById(String id) {
        return feedbackRepository.findById(id);
    }

    @Override
    public List<Feedback> getFeedbackByTrainerId(String trainerId) {
        return feedbackRepository.findByTrainerId(trainerId);
    }

    @Override
    public List<Feedback> getFeedbackByMemberId(String memberId) {
        return feedbackRepository.findByMemberId(memberId);
    }

    @Override
    public Feedback updateFeedback(String id, FeedbackRequest feedbackRequest) {
        Optional<Feedback> optionalFeedback = feedbackRepository.findById(id);
        if (optionalFeedback.isPresent()) {
            Feedback feedback = optionalFeedback.get();
            feedback.setComments(feedbackRequest.getComments());
            feedback.setRating(feedbackRequest.getRating());
            return feedbackRepository.save(feedback);
        } else {
            throw new NoSuchElementException("Feedback not found");
        }
    }

    @Override
    public void deleteFeedbackById(String id) {
        feedbackRepository.deleteById(id);
    }
}
