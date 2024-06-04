package com.EquipMgmt.EquipMgmtspringboot.Services;

import com.EquipMgmt.EquipMgmtspringboot.Models.EquipmentSystem;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public interface EquipmentSystemService {
    List<EquipmentSystem> findAll();
    Optional<EquipmentSystem> getEquipmentSystemById(Long id);
    void save(EquipmentSystem equipmentSystem);
    void deleteById(Long id);
}