package com.EquipMgmt.EquipMgmtspringboot.Services;

import com.EquipMgmt.EquipMgmtspringboot.Models.Accessory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public interface AccessoryService {
    List<Accessory> findAll();
    Optional<Accessory> getAccessoryById(Long id);
    void save(Accessory accessory);
    void deleteById(Long id);
}