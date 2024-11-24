package com.example.SpringMongoProject.Controller;

import com.example.SpringMongoProject.Entity.Equipment;
import com.example.SpringMongoProject.Service.EquipmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins ="*")
@RequestMapping("api/v1/equipment")