package com.EquipMgmt.EquipMgmtspringboot.Services;

import com.EquipMgmt.EquipMgmtspringboot.Models.MaintenanceStatus;
import com.EquipMgmt.EquipMgmtspringboot.Repository.MaintenanceStatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MaintenanceStatusServiceImpl implements MaintenanceStatusService {

    @Autowired
    private MaintenanceStatusRepository maintenanceStatusRepository;

    @Override
    public List<MaintenanceStatus> findAll() {
        return maintenanceStatusRepository.findAll();
    }

    @Override
    public Optional<MaintenanceStatus> getMaintenanceStatusById(Long id) {
        return maintenanceStatusRepository.findById(id);
    }

    @Override
    public void save(MaintenanceStatus maintenanceStatus) {
        maintenanceStatusRepository.save(maintenanceStatus);
    }

    @Override
    public void deleteById(Long id) {
        maintenanceStatusRepository.deleteById(id);
    }
}
