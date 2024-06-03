package com.EquipMgmt.EquipMgmtspringboot.Services;

import com.EquipMgmt.EquipMgmtspringboot.Models.MaintenanceType;

import java.util.List;
import java.util.Optional;

public interface MaintenanceTypeService {
    List<MaintenanceType> findAll();
    Optional<MaintenanceType> findById(Long id);
    MaintenanceType save(MaintenanceType maintenanceType);
    void deleteById(Long id);
}