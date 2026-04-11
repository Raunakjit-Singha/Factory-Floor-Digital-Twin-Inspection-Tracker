package com.factory.inspection.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import com.factory.inspection.entity.Inspection;
import com.factory.inspection.repository.InspectionRepository;

@RestController
@RequestMapping("/inspection")
public class InspectionController {

    @Autowired
    private InspectionRepository repository;

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping
    public List<Inspection> getAll() {
        return repository.findAll();
    }

    @PostMapping
    public Inspection create(@RequestBody Inspection inspection) {

        Inspection saved = repository.save(inspection);

        // call notification service
        restTemplate.postForObject(
                "http://localhost:8085/notification",
                "Inspection created for equipment " + inspection.getEquipmentId(),
                String.class
        );

        return saved;
    }
}