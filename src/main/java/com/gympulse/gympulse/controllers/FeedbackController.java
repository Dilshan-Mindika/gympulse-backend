package com.gympulse.gympulse.controllers;

import com.gympulse.gympulse.model.feedback.Feedback;
import com.gympulse.gympulse.requests.FeedbackRequest;
import com.gympulse.gympulse.service.interfaces.FeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/feedbacks")
public class FeedbackController {
    @Autowired
    private FeedbackService feedbackService;

    @PostMapping
    public ResponseEntity<Feedback> createFeedback(@RequestBody FeedbackRequest feedbackRequest) {
        Feedback createdFeedback = feedbackService.createFeedback(feedbackRequest);
        return ResponseEntity.ok(createdFeedback);
    }

    @GetMapping
    public ResponseEntity<List<Feedback>> getAllFeedbacks() {
        List<Feedback> feedbacks = feedbackService.getAllFeedbacks();
        return ResponseEntity.ok(feedbacks);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Feedback> getFeedbackById(@PathVariable String id) {
        return feedbackService.getFeedbackById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/trainer/{trainerId}")
    public ResponseEntity<List<Feedback>> getFeedbackByTrainerId(@PathVariable String trainerId) {
        List<Feedback> feedbacks = feedbackService.getFeedbackByTrainerId(trainerId);
        return ResponseEntity.ok(feedbacks);
    }

    @GetMapping("/member/{memberId}")
    public ResponseEntity<List<Feedback>> getFeedbackByMemberId(@PathVariable String memberId) {
        List<Feedback> feedbacks = feedbackService.getFeedbackByMemberId(memberId);
        return ResponseEntity.ok(feedbacks);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Feedback> updateFeedback(@PathVariable String id, @RequestBody FeedbackRequest feedbackRequest) {
        Feedback updatedFeedback = feedbackService.updateFeedback(id, feedbackRequest);
        return ResponseEntity.ok(updatedFeedback);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFeedback(@PathVariable String id) {
        feedbackService.deleteFeedbackById(id);
        return ResponseEntity.noContent().build();
    }
}
