package com.EquipMgmt.EquipMgmtspringboot.Services;

import com.EquipMgmt.EquipMgmtspringboot.Models.MaintenanceType;
import com.EquipMgmt.EquipMgmtspringboot.Repository.MaintenanceTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MaintenanceTypeServiceImpl implements MaintenanceTypeService {

    @Autowired
    private MaintenanceTypeRepository maintenanceTypeRepository;

    @Override
    public List<MaintenanceType> findAll() {
        return maintenanceTypeRepository.findAll();
    }


    @Override
    public Optional<MaintenanceType> findById(Long id) {
        return maintenanceTypeRepository.findById(id);
    }

    @Override
    public MaintenanceType save(MaintenanceType maintenanceType) {
        return maintenanceTypeRepository.save(maintenanceType);
    }

    @Override
    public void deleteById(Long id) {
        maintenanceTypeRepository.deleteById(id);
    }
}
