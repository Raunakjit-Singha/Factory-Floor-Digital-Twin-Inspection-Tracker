package com.factory.inspection.service;

import org.springframework.stereotype.Service;
import java.util.List;
import com.factory.inspection.entity.Inspection;
import com.factory.inspection.repository.InspectionRepository;

@Service
public class InspectionService {

    private final InspectionRepository repository;

    public InspectionService(InspectionRepository repository) {
        this.repository = repository;
    }

    public List<Inspection> getAll() {
        return repository.findAll();
    }

    public Inspection save(Inspection inspection) {
        return repository.save(inspection);
    }
}