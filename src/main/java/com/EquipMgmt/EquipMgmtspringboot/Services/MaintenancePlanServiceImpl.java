package com.EquipMgmt.EquipMgmtspringboot.Services;

import com.EquipMgmt.EquipMgmtspringboot.Models.MaintenancePlan;
import com.EquipMgmt.EquipMgmtspringboot.Repository.MaintenancePlanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MaintenancePlanServiceImpl implements MaintenancePlanService {

    @Autowired
    private MaintenancePlanRepository maintenancePlanRepository;

    @Override
    public List<MaintenancePlan> findAll() {
        return maintenancePlanRepository.findAll();
    }

    @Override
    public Optional<MaintenancePlan> getMaintenancePlanById(Long id) {
        return maintenancePlanRepository.findById(id);
    }

    @Override
    public void save(MaintenancePlan maintenance) {
        maintenancePlanRepository.save(maintenance);
    }

    @Override
    public void deleteById(Long id) {
        maintenancePlanRepository.deleteById(id);
    }
}
