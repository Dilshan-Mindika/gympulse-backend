package com.gympulse.gympulse.service;

import com.gympulse.gympulse.model.person.Trainer;
import com.gympulse.gympulse.repositories.TrainerRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class TrainerServiceImpl implements TrainerService{

    @Autowired
    private TrainerRepository trainerRepository;

    @Override
    public Trainer createTrainer(String trainerId, String speciality, Double salary, String certificationNumber,
                                            String fullName, String phoneNumber, String address, String email){
        // Generates a unique trainer ID
        String trainerId = generateNextTrainerId();
        if (trainerId != null) {
            Trainer trainer = trainerRepository.insert(new Trainer(trainerId, speciality, salary, certificationNumber,
                    fullName, phoneNumber, address, email));
            return trainer;
        } else {
            throw new IllegalStateException("Trainer limit reached. Cannot create more trainers.");
        }
    }

    @Override
    public List<Trainer> allTrainers(){
        return trainerRepository.findAll()
    }

    @Override
    public Optional<Trainer> trainerById(String traineId) {
        return trainerRepository.findByTrainerID(traineId);
    }
}
