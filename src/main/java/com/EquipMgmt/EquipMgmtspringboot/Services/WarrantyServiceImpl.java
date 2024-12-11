package com.EquipMgmt.EquipMgmtspringboot.Services;

import com.EquipMgmt.EquipMgmtspringboot.Models.Warranty;
import com.EquipMgmt.EquipMgmtspringboot.Repository.WarrantyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class WarrantyServiceImpl implements WarrantyService {

    @Autowired
    private WarrantyRepository warrantyRepository;

    @Override
    public List<Warranty> findAll() {
        return warrantyRepository.findAll();
    }

    @Override
    public Optional<Warranty> getWarrantyById(Long id) {
        return warrantyRepository.findById(id);
    }

    @Override
    public void save(Warranty warranty) {
        warrantyRepository.save(warranty);
    }

    @Override
    public void deleteById(Long id) {
        warrantyRepository.deleteById(id);
    }
}
