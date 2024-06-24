package com.EquipMgmt.EquipMgmtspringboot.Services;

import com.EquipMgmt.EquipMgmtspringboot.Models.MaintenanceStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public interface MaintenanceStatusService {
    List<MaintenanceStatus> findAll();
    Optional<MaintenanceStatus> getMaintenanceStatusById(Long id);
    void save(MaintenanceStatus maintenanceStatus);
    void deleteById(Long id);
}