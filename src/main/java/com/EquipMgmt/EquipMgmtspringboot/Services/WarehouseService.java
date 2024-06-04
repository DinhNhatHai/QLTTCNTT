package com.EquipMgmt.EquipMgmtspringboot.Services;

import com.EquipMgmt.EquipMgmtspringboot.Models.Warehouse;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface WarehouseService {
    List<Warehouse> findAll();
    Optional<Warehouse> getWarehouseById(Long id);
    void save(Warehouse warehouse);
    void deleteById(Long id);
}
