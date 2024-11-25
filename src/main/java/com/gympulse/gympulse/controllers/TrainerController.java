package com.nexus.GYMPULSE.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.nexus.GYMPULSE.model.person.Trainer;
import com.nexus.GYMPULSE.requests.TrainerRequest;
import com.nexus.GYMPULSE.service.interfaces.TrainerService;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/Trainers") // Base URL for trainer-related endpoints
public class TrainerController {

    @Autowired
    private TrainerService trainerService; // Injecting the TrainerService to manage business logic

    // Endpoint to retrieve all trainers
    @GetMapping
    public ResponseEntity<List<Trainer>> getAllTrainers() {
        return new ResponseEntity<List<Trainer>>(trainerService.allTrainers(), HttpStatus.OK); // Return list of trainers with OK status
    }

    // Endpoint to create a new trainer
    @PostMapping
    public Trainer createTrainer(@RequestBody TrainerRequest trainerRequest) {
        // Extracting trainer details from the request
        String speciality = trainerRequest.getSpeciality();
        Double salary = trainerRequest.getSalary();
        String certificationNumber = trainerRequest.getCertificationNumber();
        String fullName = trainerRequest.getFullName();
        String phoneNumber = trainerRequest.getPhoneNumber();
        String address = trainerRequest.getAddress();
        String email = trainerRequest.getEmail();

        // Creating and returning the new trainer
        return trainerService.createTrainer(speciality, salary, certificationNumber, fullName,
                phoneNumber, address, email);
    }

    // Endpoint to retrieve a specific trainer by their ID
    @GetMapping("/{trainerId}")
    public ResponseEntity<Optional<Trainer>> getTrainerById(@PathVariable String trainerId) {
        return new ResponseEntity<Optional<Trainer>>(trainerService.trainerById(trainerId), HttpStatus.OK); // Return trainer by ID
    }

    // Endpoint to update an existing trainer's details by their ID
    @PutMapping("/{trainerId}")
    public Trainer updateTrainer(@PathVariable String trainerId, @RequestBody TrainerRequest trainerRequest) {
        return trainerService.updateTrainer(trainerId, trainerRequest); // Update and return the modified trainer
    }

    // Endpoint to delete a trainer by their ID
    @DeleteMapping("/{trainerId}")
    public ResponseEntity<Void> deleteTrainer(@PathVariable String trainerId) {
        trainerService.deleteByTrainerId(trainerId); // Delete the trainer
        return new ResponseEntity<>(HttpStatus.NO_CONTENT); // Return no content response
    }
}
