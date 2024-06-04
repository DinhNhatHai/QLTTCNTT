package com.EquipMgmt.EquipMgmtspringboot.Services;

import com.EquipMgmt.EquipMgmtspringboot.Models.StatusEquipmentType;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface StatusEquipmentTypeService {
    List<StatusEquipmentType> findAll();
    Optional<StatusEquipmentType> getStatusEquipmentTypeById(Long id);
    void save(StatusEquipmentType statusEquipmentType);
    void deleteById(Long id);
}
