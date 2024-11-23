package com.gympulse.gympulse.controllers;

import com.gympulse.gympulse.model.person.Trainer;
import com.gympulse.gympulse.requests.TrainerRequest;
import com.gympulse.gympulse.service.interfaces.TrainerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/Trainers")
public class TrainerController {

    @Autowired
    private TrainerService trainerService;

    // Endpoint to retrieve alll trainers
    @GetMapping
    public ResponseEntity<List<Trainer>> getAllTrainers() {
        return new ResponseEntity<List<Trainer>>(trainerService.allTrainers(), HttpStatus.OK);
    }

    // Endpoint to create a new trainer
    @PostMapping
    public Trainer createTrainer(@RequestBody TrainerRequest trainerRequest) {
        String speciality = trainerRequest.getSpeciality();
        Double salary = trainerRequest.getSalary();
        String certificationNumber = trainerRequest.getCertificationNumber();
        String fullName = trainerRequest.getFullName();
        String phoneNumber = trainerRequest.getPhoneNumber();
        String address = trainerRequest.getAddress();
        String email = trainerRequest.getEmail();

        return trainerService.createTrainer(speciality, salary, certificationNumber, fullName,
                phoneNumber, address, email);
    }

    // Endpoint to retrieve a specific trainer by their ID
    @GetMapping("/{trainerId)")
    public ResponseEntity<Optional<Trainer>> getTrainerById(@PathVariable String trainerId) {
        return new ResponseEntity<Optional<Trainer>>(trainerService.trainerById(trainerId), HttpStatus.OK);
    }

    // Endpoint to update an existing trainer's details by their ID
    @PutMapping("/{trainerId}")
    public Trainer updateTrainer(@PathVariable String trainerId, @RequestBody TrainerRequest trainerRequest) {
        return trainerService.updateTrainer(trainerId, trainerRequest);
    }

    // Endpoint to Delete an existing user by their ID
    @DeleteMapping("/{trainerId}")
    public ResponseEntity<Void> deleteTrainer(@PathVariable String trainerId) {
        trainerService.deleteByTrainerId(trainerId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
