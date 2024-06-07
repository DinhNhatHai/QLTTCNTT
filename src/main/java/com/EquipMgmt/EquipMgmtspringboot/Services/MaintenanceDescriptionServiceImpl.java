package com.EquipMgmt.EquipMgmtspringboot.Services;

import com.EquipMgmt.EquipMgmtspringboot.Models.MaintenanceDescription;
import com.EquipMgmt.EquipMgmtspringboot.Repository.MaintenanceDescriptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MaintenanceDescriptionServiceImpl implements MaintenanceDescriptionService {

    @Autowired
    private MaintenanceDescriptionRepository maintenanceDescriptionRepository;

    @Override
    public List<MaintenanceDescription> findAll() {
        return maintenanceDescriptionRepository.findAll();
    }

    @Override
    public Optional<MaintenanceDescription> getMaintenanceDescriptionById(Long id) {
        return maintenanceDescriptionRepository.findById(id);
    }

    @Override
    public void save(MaintenanceDescription maintenanceDescription) {
        maintenanceDescriptionRepository.save(maintenanceDescription);
    }

    @Override
    public void deleteById(Long id) {
        maintenanceDescriptionRepository.deleteById(id);
    }
}
