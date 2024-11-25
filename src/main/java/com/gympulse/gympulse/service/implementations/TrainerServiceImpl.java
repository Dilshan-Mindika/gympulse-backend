package com.nexus.GYMPULSE.service.implementations;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nexus.GYMPULSE.model.person.Trainer;
import com.nexus.GYMPULSE.repositories.TrainerRepository;
import com.nexus.GYMPULSE.requests.TrainerRequest;
import com.nexus.GYMPULSE.service.interfaces.TrainerService;
import com.nexus.GYMPULSE.utils.GymLogger;

@Service
public class TrainerServiceImpl implements TrainerService {

    private GymLogger logger = GymLogger.getInstance();

    @Autowired
    private TrainerRepository trainerRepository;

    @Override
    public Trainer createTrainer(String speciality, Double salary, String certificationNumber, String fullName,
                                 String phoneNumber, String address, String email) {
        // Generate a unique trainer ID
        String trainerId = generateNextTrainerId();
        if (trainerId != null) {
            Trainer trainer = trainerRepository.insert(new Trainer(trainerId, speciality, salary, certificationNumber,
                    fullName, phoneNumber, address, email));
            logger.log("New Trainer created, Trainer ID: " + trainerId);
            return trainer;
        } else {
            throw new IllegalStateException("Trainer limit reached. Cannot create more trainers.");
        }
    }

    @Override
    public List<Trainer> allTrainers() {
        // Retrieve all trainers from the repository
        return trainerRepository.findAll();
    }

    @Override
    public Optional<Trainer> findTrainerById(String trainerId) {
        return Optional.empty();
    }

    @Override
    public Optional<Trainer> trainerById(String trainerId) {
        // Find a trainer by their trainer ID
        return trainerRepository.findByTrainerId(trainerId);
    }

    @Override
    public Trainer updateTrainer(String trainerId, TrainerRequest trainerRequest) {
        // Update an existing trainer's details
        Optional<Trainer> optionalTrainer = trainerRepository.findByTrainerId(trainerId);
        if (optionalTrainer.isPresent()) {
            Trainer trainer = optionalTrainer.get();
            trainer.setSpeciality(trainerRequest.getSpeciality());
            trainer.setSalary(trainerRequest.getSalary());
            trainer.setCertificationNumber(trainerRequest.getCertificationNumber());
            trainer.setFullName(trainerRequest.getFullName());
            trainer.setPhoneNumber(trainerRequest.getPhoneNumber());
            trainer.setAddress(trainerRequest.getAddress());
            trainer.setEmail(trainerRequest.getEmail());
            logger.log("Trainer updated, Trainer ID: " + trainerId);
            return trainerRepository.save(trainer);
        } else {
            throw new NoSuchElementException("Trainer not found for ID: " + trainerId);
        }
    }

    @Override
    public void deleteByTrainerId(String trainerId) {
        // Delete a trainer by their trainer ID
        Optional<Trainer> trainer = trainerRepository.findByTrainerId(trainerId);
        if (trainer.isPresent()) {
            logger.log("Trainer deleted, ID: " + trainerId);
            trainerRepository.delete(trainer.get());
        } else {
            throw new NoSuchElementException("Trainer not found for ID: " + trainerId);
        }
    }

    private String generateNextTrainerId() {
        // Generate the next unique trainer ID
        List<Trainer> trainers = allTrainers();
        Set<String> usedIds = trainers.stream().map(Trainer::getTrainerId).collect(Collectors.toSet());

        for (int i = 1; i <= 9999; i++) {
            String candidateId = String.format("%04d", i);
            if (!usedIds.contains(candidateId)) {
                return candidateId; // Return the first unused ID
            }
        }
        return null; // No available ID found
    }
}
