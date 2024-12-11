package com.EquipMgmt.EquipMgmtspringboot.Services;

import com.EquipMgmt.EquipMgmtspringboot.Models.MaintenanceSchedule;
import com.EquipMgmt.EquipMgmtspringboot.Repository.MaintenanceScheduleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MaintenanceScheduleServiceImpl implements MaintenanceScheduleService {

    @Autowired
    private MaintenanceScheduleRepository maintenanceScheduleRepository;

    @Override
    public List<MaintenanceSchedule> findAll() {
        return maintenanceScheduleRepository.findAll();
    }

    @Override
    public Optional<MaintenanceSchedule> getMaintenanceScheduleById(Long id) {
        return maintenanceScheduleRepository.findById(id);
    }

    @Override
    public void save(MaintenanceSchedule maintenanceSchedule) {
        maintenanceScheduleRepository.save(maintenanceSchedule);
    }

    @Override
    public void deleteById(Long id) {
        maintenanceScheduleRepository.deleteById(id);
    }
}
