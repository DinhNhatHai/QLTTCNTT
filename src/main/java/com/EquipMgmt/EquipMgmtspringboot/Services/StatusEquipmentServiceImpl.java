package com.EquipMgmt.EquipMgmtspringboot.Services;

import com.EquipMgmt.EquipMgmtspringboot.Models.StatusEquipment;
import com.EquipMgmt.EquipMgmtspringboot.Repository.StatusEquipmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StatusEquipmentServiceImpl implements StatusEquipmentService {

    @Autowired
    private StatusEquipmentRepository statusEquipmentRepository;

    @Override
    public List<StatusEquipment> findAll() {
        return statusEquipmentRepository.findAll();
    }

    @Override
    public Optional<StatusEquipment> getStatusEquipmentById(Long id) {
        return statusEquipmentRepository.findById(id);
    }

    @Override
    public void save(StatusEquipment statusEquipmentType) {
        statusEquipmentRepository.save(statusEquipmentType);
    }

    @Override
    public void deleteById(Long id) {
        statusEquipmentRepository.deleteById(id);
    }
}
