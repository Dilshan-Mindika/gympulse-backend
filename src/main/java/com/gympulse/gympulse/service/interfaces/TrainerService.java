package com.gympulse.gympulse.service.interfaces;

import com.gympulse.gympulse.model.person.Trainer;
import com.gympulse.gympulse.requests.TrainerRequest;

import java.util.List;
import java.util.Optional;

/**
 * Service interface for managing trainers.
 */
public interface TrainerService {

    /**
     * Create a new Trainer
     *
     * @param speciality the speciality of the trainer
     * @param salary the salary of the trainer
     * @param certificationNumber the certification number of the trainer
     * @param fullName the full name of the trainer
     * @param address the address of the trainer
     * @param email the email of the trainer
     * @return the created Trainer
     */
    Trainer createTrainer(String trainerId, String speciality, Double salary, String certificationNumber,
                          String fullName, String phoneNumber, String address, String email);

    /**
     * Retrieves all trainers.
     *
     * @return a list of all Trainers
     */
    List<Trainer> allTrainers();

    /**
     * Find a trainer by their ID
     *
     * @param trainerId the ID of the trainer
     * @return an Optional containing the Trainer if found, or empty if not
     */
    Optional<Trainer> trainerById(String trainerId);

    /**
     * Updates an existing trainer's information.
     *
     * @param trainerId the id of the trainer
     * @param trainerRequest the new data for the trainer
     * @return the updated Trainer
     */
    Trainer updateTrainer(String trainerId, TrainerRequest trainerRequest);

    /**
     * Delete a trainer by their ID
     *
     * @param trainerID of the trainer to delete
     *
     */
    void deleteByTrainerId(String trainerID);
}
