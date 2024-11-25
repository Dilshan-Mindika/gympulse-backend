package com.gympulse.gympulse.model.feedback;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document(collection = "feedbacks")
public class Feedback {
    @Id
    private String id; // Unique identifier for the feedback
    private String memberId; // ID of the member giving feedback
    private String trainerId; // ID of the trainer (optional)
    private String comments; // Feedback comments
    private int rating; // Rating out of 5
    private LocalDateTime createdAt; // Timestamp of feedback creation

    // Constructors
    public Feedback() {}

    public Feedback(String memberId, String trainerId, String comments, int rating) {
        this.memberId = memberId;
        this.trainerId = trainerId;
        this.comments = comments;
        this.rating = rating;
        this.createdAt = LocalDateTime.now(); // Set current timestamp
    }

    // Getters and Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMemberId() {
        return memberId;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }

    public String getTrainerId() {
        return trainerId;
    }

    public void setTrainerId(String trainerId) {
        this.trainerId = trainerId;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}
