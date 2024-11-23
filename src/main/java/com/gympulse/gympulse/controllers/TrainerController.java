package com.gympulse.gympulse.controllers;

import com.gympulse.gympulse.model.person.Trainer;
import com.gympulse.gympulse.service.interfaces.TrainerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/Trainers")
public class TrainerController {

    @Autowired
    private TrainerService trainerService;

    @GetMapping
    public ResponseEntity<List<Trainer>> getAllTrainers() {
        return new ResponseEntity<List<Trainer>>(trainerService.allTrainers(), HttpStatus.OK)
    }
}
