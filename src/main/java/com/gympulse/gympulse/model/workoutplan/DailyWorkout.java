package com.nexus.GYMPULSE.model.workoutplan;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//  a daily workout plan for a specific day of the week
@Document(collection = "dailyWorkouts") 
@Data
@AllArgsConstructor 
@NoArgsConstructor 
public class DailyWorkout {
    @Id
    private String id; //  identifier for the daily workout
    private String dayOfWeek; // Day of the week for this workout
    @DocumentReference
    private List<Exercise> exercises; // List of exercises included in this workout

    //  for creating a DailyWorkout with specified day and exercises
    public DailyWorkout(String dayOfWeek, List<Exercise> exercises) {
        this.dayOfWeek = dayOfWeek;
        this.exercises = exercises;
    }
}
