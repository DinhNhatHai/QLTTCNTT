package com.EquipMgmt.EquipMgmtspringboot.Services;

import com.EquipMgmt.EquipMgmtspringboot.Models.MaintenanceSchedule;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public interface MaintenanceScheduleService {
    List<MaintenanceSchedule> findAll();
    Optional<MaintenanceSchedule> getMaintenanceScheduleById(Long id);
    void save(MaintenanceSchedule maintenanceSchedule);
    void deleteById(Long id);
}