package com.EquipMgmt.EquipMgmtspringboot.Services;

import com.EquipMgmt.EquipMgmtspringboot.Models.StatusEquipment;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface StatusEquipmentService {
    List<StatusEquipment> findAll();
    Optional<StatusEquipment> getStatusEquipmentById(Long id);
    void save(StatusEquipment statusEquipment);
    void deleteById(Long id);
}
