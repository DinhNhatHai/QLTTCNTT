package com.EquipMgmt.EquipMgmtspringboot.Services;

import com.EquipMgmt.EquipMgmtspringboot.Models.Equipment;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public interface EquipmentService {
    List<Equipment> findAll();
    List<Equipment> findEquipmentsByType(Long equipmentTypeId);
    Optional<Equipment> getEquipmentById(Long id);

    void save(Equipment equipment);
    void deleteById(Long id);
}