package com.gympulse.gympulse.Controller;


import com.gympulse.gympulse.Entity.Equipment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins ="*")
@RequestMapping("api/v1/equipment")?


public class EquipmentController {



    @PostMapping(value = "/save")
    private String saveEquipment(@RequestBody Equipment equipments)
    {
        equipmentService.saveorUpdate(equipments);
        return equipments.get_id();
    }
}
