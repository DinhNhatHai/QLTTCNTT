package com.EquipMgmt.EquipMgmtspringboot.Services;

import com.EquipMgmt.EquipMgmtspringboot.Models.MaintenanceDescription;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public interface MaintenanceDescriptionService {
    List<MaintenanceDescription> findAll();
    Optional<MaintenanceDescription> getMaintenanceDescriptionById(Long id);
    void save(MaintenanceDescription maintenanceDescription);
    void deleteById(Long id);
}