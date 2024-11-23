package com.nexus.GYMPULSE.service.implementations;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nexus.GYMPULSE.model.workoutplan.DailyWorkout;
import com.nexus.GYMPULSE.model.workoutplan.Exercise;
import com.nexus.GYMPULSE.repositories.DailyWorkoutRepository;
import com.nexus.GYMPULSE.requests.DailyWorkoutRequest;
import com.nexus.GYMPULSE.service.interfaces.DailyWorkoutService;
import com.nexus.GYMPULSE.utils.GymLogger;

@Service
public class DailyWorkoutImpl implements DailyWorkoutService {
    private GymLogger logger = GymLogger.getInstance();

    @Autowired
    private DailyWorkoutRepository dailyWorkoutRepository;

    @Override
    public DailyWorkout createDailyWorkout(String dayOfWeek, List<Exercise> exercises) {
        // Create a new DailyWorkout and save it repository
        DailyWorkout dailyWorkout = dailyWorkoutRepository.insert(new DailyWorkout(dayOfWeek, exercises));
        logger.log("New DailyWorkout created, Day of Week: " + dayOfWeek);
        return dailyWorkout;
    }

    @Override
    public List<DailyWorkout> allDailyWorkouts() {
        // Return all DailyWorkouts from repository
        return dailyWorkoutRepository.findAll();
    }

    @Override
    public Optional<DailyWorkout> dailyWorkoutByDayOfWeek(String dayOfWeek) {
        // Retrieve a DailyWorkout by specified day of the week
        return dailyWorkoutRepository.findDailyWorkoutByDayOfWeek(dayOfWeek);
    }

    @Override
    public Optional<DailyWorkout> dailyWorkoutById(String id) {
        // Retrieve a DailyWorkout by ID
        return dailyWorkoutRepository.findDailyWorkoutById(id);
    }

    @Override
    public Optional<DailyWorkout> findDailyWorkoutByDayOfWeek(String dayOfWeek) {
        return Optional.empty();
    }

    @Override
    public DailyWorkout updateDailyWorkout(String id, DailyWorkoutRequest dailyWorkoutRequest) {
        // Update an existing DailyWorkout
        Optional<DailyWorkout> optionalDailyWorkout = dailyWorkoutRepository.findDailyWorkoutById(id);
        if (optionalDailyWorkout.isPresent()) {
            DailyWorkout dailyWorkout = optionalDailyWorkout.get();
            dailyWorkout.setDayOfWeek(dailyWorkoutRequest.getDayOfWeek());
            dailyWorkout.setExercises(dailyWorkoutRequest.getExercises());
            logger.log("DailyWorkout updated, ID: " + id);
            return dailyWorkoutRepository.save(dailyWorkout);
        } else {
            throw new NoSuchElementException("DailyWorkout not found for ID: " + id);
        }
    }

    @Override
    public void deleteDailyWorkout(String id) {
        // Delete a DailyWorkout by ID
        Optional<DailyWorkout> dailyWorkout = dailyWorkoutRepository.findDailyWorkoutById(id);
        if (dailyWorkout.isPresent()) {
            logger.log("DailyWorkout deleted, ID: " + id);
            dailyWorkoutRepository.delete(dailyWorkout.get());
        } else {
            throw new NoSuchElementException("DailyWorkout not found for ID: " + id);
        }
    }
}
