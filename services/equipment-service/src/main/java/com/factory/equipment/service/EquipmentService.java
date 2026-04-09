package com.factory.equipment.service;

import com.factory.equipment.entity.Equipment;
import com.factory.equipment.repository.EquipmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EquipmentService {

    @Autowired
    private EquipmentRepository repository;

    public Equipment save(Equipment equipment) {
        return repository.save(equipment);
    }

    public List<Equipment> getAll() {
        return repository.findAll();
    }

    public Equipment getById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}