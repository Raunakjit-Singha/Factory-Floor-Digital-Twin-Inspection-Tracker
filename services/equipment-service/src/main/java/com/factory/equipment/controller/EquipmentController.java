package com.factory.equipment.controller;

import com.factory.equipment.entity.Equipment;
import com.factory.equipment.service.EquipmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/equipment")
public class EquipmentController {

    @Autowired
    private EquipmentService service;

    @PostMapping
    public Equipment add(@RequestBody Equipment equipment) {
        return service.save(equipment);
    }

    @GetMapping
    public List<Equipment> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public Equipment getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}