package com.EquipMgmt.EquipMgmtspringboot.Services;

import com.EquipMgmt.EquipMgmtspringboot.Models.Equipment;
import com.EquipMgmt.EquipMgmtspringboot.Repository.EquipmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EquipmentServiceImpl implements EquipmentService {

    @Autowired
    private EquipmentRepository equipmentSystemRepository;

    @Override
    public List<Equipment> findAll() {
        return equipmentSystemRepository.findAll();
    }

    @Override
    public Optional<Equipment> getEquipmentById(Long id) {
        return equipmentSystemRepository.findById(id);
    }

    @Override
    public void save(Equipment accessory) {
        equipmentSystemRepository.save(accessory);
    }

    @Override
    public void deleteById(Long id) {
        equipmentSystemRepository.deleteById(id);
    }
}
