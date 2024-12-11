package com.EquipMgmt.EquipMgmtspringboot.Services;

import com.EquipMgmt.EquipMgmtspringboot.Models.EquipmentType;
import com.EquipMgmt.EquipMgmtspringboot.Repository.EquipmentTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EquipmentTypeServiceImpl implements EquipmentTypeService {

    @Autowired
    private EquipmentTypeRepository equipmentTypeRepository;

    @Override
    public List<EquipmentType> findAll() {
        return equipmentTypeRepository.findAll();
    }

    @Override
    public void save(EquipmentType equipmentType) {
        equipmentTypeRepository.save(equipmentType);
    }

    @Override
    public void deleteById(Long id) {
        equipmentTypeRepository.deleteById(id);
    }

    @Override
    public Optional<EquipmentType> getEquipmentTypeById(Long id) {
        return equipmentTypeRepository.findById(id);
    }

}
