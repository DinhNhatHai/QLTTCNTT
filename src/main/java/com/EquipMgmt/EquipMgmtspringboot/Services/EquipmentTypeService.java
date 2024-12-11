package com.EquipMgmt.EquipMgmtspringboot.Services;

import com.EquipMgmt.EquipMgmtspringboot.Models.EquipmentType;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface EquipmentTypeService {
    List<EquipmentType> findAll();
    Optional<EquipmentType> getEquipmentTypeById(Long id);
    void save(EquipmentType equipmentType);
    void deleteById(Long id);
}
