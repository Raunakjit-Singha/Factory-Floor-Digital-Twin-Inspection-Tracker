package com.factory.inspection.controller;

import org.springframework.web.bind.annotation.*;
import java.util.List;

import com.factory.inspection.entity.Inspection;
import com.factory.inspection.service.InspectionService;

@RestController
@RequestMapping("/inspection")
public class InspectionController {

    private final InspectionService service;

    public InspectionController(InspectionService service) {
        this.service = service;
    }

    @GetMapping
    public List<Inspection> getAll() {
        return service.getAll();
    }

    @PostMapping
    public Inspection create(@RequestBody Inspection inspection) {
        return service.save(inspection);
    }
}