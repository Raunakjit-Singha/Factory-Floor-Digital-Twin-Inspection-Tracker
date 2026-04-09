package com.factory.inspection.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.factory.inspection.entity.Inspection;

public interface InspectionRepository extends JpaRepository<Inspection, Long> {
}