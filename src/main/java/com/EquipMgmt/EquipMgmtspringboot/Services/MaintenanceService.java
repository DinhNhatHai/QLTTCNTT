package com.EquipMgmt.EquipMgmtspringboot.Services;

import com.EquipMgmt.EquipMgmtspringboot.Models.Maintenance;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public interface MaintenanceService {
    List<Maintenance> findAll();
    Optional<Maintenance> getMaintenanceById(Long id);
    void save(Maintenance maintenance);
    void deleteById(Long id);
}