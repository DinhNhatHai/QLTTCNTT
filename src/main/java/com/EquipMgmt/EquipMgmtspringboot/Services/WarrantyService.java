package com.EquipMgmt.EquipMgmtspringboot.Services;

import com.EquipMgmt.EquipMgmtspringboot.Models.Warranty;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public interface WarrantyService {
    List<Warranty> findAll();
    Optional<Warranty> getWarrantyById(Long id);
    void save(Warranty warranty);
    void deleteById(Long id);
}