package com.EquipMgmt.EquipMgmtspringboot.Services;

import com.EquipMgmt.EquipMgmtspringboot.Models.Equipment;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface EquipmentService {
    Equipment saveEquipment(Equipment equipment);
    Optional<Equipment> getEquipmentById(Long id);
    List<Equipment> getAllEquipments();
    void deleteEquipment(Long id);
    List<Equipment> getAllEquipmentsByIds(List<Long> ids);
    List<Equipment> saveAllEquipments(List<Equipment> equipments);
}