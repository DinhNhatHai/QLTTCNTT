package com.EquipMgmt.EquipMgmtspringboot.Services;

import com.EquipMgmt.EquipMgmtspringboot.Models.StatusEquipmentType;
import com.EquipMgmt.EquipMgmtspringboot.Repository.StatusEquipmentTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StatusEquipmentTypeServiceImpl implements StatusEquipmentTypeService {

    @Autowired
    private StatusEquipmentTypeRepository statusEquipmentTypeRepository;

    @Override
    public List<StatusEquipmentType> findAll() {
        return statusEquipmentTypeRepository.findAll();
    }

    @Override
    public Optional<StatusEquipmentType> getStatusEquipmentTypeById(Long id) {
        return statusEquipmentTypeRepository.findById(id);
    }

    @Override
    public void save(StatusEquipmentType statusEquipmentType) {
        statusEquipmentTypeRepository.save(statusEquipmentType);
    }

    @Override
    public void deleteById(Long id) {
        statusEquipmentTypeRepository.deleteById(id);
    }
}
