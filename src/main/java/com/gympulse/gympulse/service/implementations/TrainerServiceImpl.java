package com.gympulse.gympulse.service.implementations;

import com.gympulse.gympulse.model.person.Trainer;
import com.gympulse.gympulse.repositories.TrainerRepository;
import com.gympulse.gympulse.requests.TrainerRequest;
import com.gympulse.gympulse.service.interfaces.TrainerService;
import com.gympulse.gympulse.utils.GymLogger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class TrainerServiceImpl implements TrainerService {

    private GymLogger logger = GymLogger.getInstance();

    @Autowired
    private TrainerRepository trainerRepository;

    @Override
    public Trainer createTrainer(String speciality, Double salary, String certificationNumber, String fullName,
                                 String phoneNumber, String address, String email) {
        // Generates a unique trainer ID
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
    public List<Trainer> allTrainers(){
        return trainerRepository.findAll();
    }

    @Override
    public Optional<Trainer> trainerById(String trainerId) {
        return trainerRepository.findByTrainerId(trainerId);
    }

    @Override
    public Trainer updateTrainer(String trainerId, TrainerRequest trainerRequest) {
        Optional<Trainer> optionalTrainer =trainerRepository.findByTrainerId(trainerId);
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
        Optional<Trainer> trainer = trainerRepository.findByTrainerId(trainerId);
        if (trainer.isPresent()) {
            logger.log("Trainer deleted, ID: " + trainerId);
            trainerRepository.delete(trainer.get());
        } else {
            throw new NoSuchElementException("Trainer not found for ID: " + trainerId);
        }
    }

    private String generateNextTrainerId() {
        List<Trainer> trainers = allTrainers();
        Set<String> usedIds = trainers.stream().map(Trainer::getTrainerId).collect(Collectors.toSet());

        for (int i = 1; i <= 9999; i++) {
            String candidateId = String.format("%04d", i);
            if (!usedIds.contains(candidateId)) {
                return candidateId;
            }
        }
        return null;
    }
}
