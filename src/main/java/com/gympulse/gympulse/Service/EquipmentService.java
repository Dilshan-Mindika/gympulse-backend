package com.gympulse.gympulse.Service;

import com.gympulse.gympulse.Entity.Equipment;
import com.gympulse.gympulse.Repo.EquipmentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service

public class EquipmentService {

    @Autowired
    private EquipmentRepo repo;

    public void saveorUpdate(Equipment equipments) {

        repo.save(equipments);
    }

    public Iterable<Equipment> listAll() {

        return this.repo.findAll();
    }

    public void deleteEquipment(String id) {
        repo.deleteById(id);

    }

    public Equipment getEquipmentByID(String equipmentid) {
        return repo.findById(equipmentid).get();


    }
}
