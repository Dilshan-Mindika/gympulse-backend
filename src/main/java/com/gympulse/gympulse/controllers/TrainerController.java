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

    @GetMapping
    public ResponseEntity<List<Trainer>> getAllTrainers() {
        return new ResponseEntity<List<Trainer>>(trainerService.allTrainers(), HttpStatus.OK)
    }

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

    @GetMapping("/{trainerId)")
    public ResponseEntity<Optional<Trainer>> getTrainerById(@PathVariable String trainerId) {
        return new ResponseEntity<Optional<Trainer>>(trainerService.trainerById(trainerId), HttpStatus.OK);
    }
}
