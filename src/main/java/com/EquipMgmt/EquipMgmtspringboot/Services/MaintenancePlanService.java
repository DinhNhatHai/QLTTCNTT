package com.EquipMgmt.EquipMgmtspringboot.Services;

import com.EquipMgmt.EquipMgmtspringboot.Models.MaintenancePlan;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public interface MaintenancePlanService {
    List<MaintenancePlan> findAll();
    Optional<MaintenancePlan> getMaintenancePlanById(Long id);
    void save(MaintenancePlan maintenancePlan);
    void deleteById(Long id);
}