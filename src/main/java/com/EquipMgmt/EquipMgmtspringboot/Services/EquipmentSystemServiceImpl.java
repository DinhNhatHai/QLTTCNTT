package com.EquipMgmt.EquipMgmtspringboot.Services;

import com.EquipMgmt.EquipMgmtspringboot.Models.EquipmentSystem;
import com.EquipMgmt.EquipMgmtspringboot.Repository.EquipmentSystemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EquipmentSystemServiceImpl implements EquipmentSystemService {

    @Autowired
    private EquipmentSystemRepository equipmentSystemRepository;

    @Override
    public List<EquipmentSystem> findAll() {
        return equipmentSystemRepository.findAll();
    }

    @Override
    public Optional<EquipmentSystem> getEquipmentSystemById(Long id) {
        return equipmentSystemRepository.findById(id);
    }

    @Override
    public void save(EquipmentSystem accessory) {
        equipmentSystemRepository.save(accessory);
    }

    @Override
    public void deleteById(Long id) {
        equipmentSystemRepository.deleteById(id);
    }
}
