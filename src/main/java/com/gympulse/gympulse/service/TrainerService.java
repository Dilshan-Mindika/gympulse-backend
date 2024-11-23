package com.gympulse.gympulse.service;

import com.gympulse.gympulse.model.person.Trainer;

import java.util.List;
import java.util.Optional;

/**
 * Service interface for managing trainers.
 */
public interface TrainerService {

    /**
     * Create a new Trainer
     *
     * @param speciality
     * @param salary
     * @param certificationNumber
     * @param fullName
     * @param address
     * @param email
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
     * @return an Optoional containing the Trainer if found, or empty if not
     */
    Optional<Trainer> trainerById(String trainerId);
}
