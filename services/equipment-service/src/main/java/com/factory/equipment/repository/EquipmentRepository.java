package com.factory.equipment.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.factory.equipment.entity.Equipment;

public interface EquipmentRepository extends JpaRepository<Equipment, Long> {
}