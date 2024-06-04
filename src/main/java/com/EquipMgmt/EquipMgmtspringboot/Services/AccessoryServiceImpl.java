package com.EquipMgmt.EquipMgmtspringboot.Services;

import com.EquipMgmt.EquipMgmtspringboot.Models.Accessory;
import com.EquipMgmt.EquipMgmtspringboot.Repository.AccessoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AccessoryServiceImpl implements AccessoryService {

    @Autowired
    private AccessoryRepository accessoryRepository;

    @Override
    public List<Accessory> findAll() {
        return accessoryRepository.findAll();
    }

    @Override
    public Optional<Accessory> getAccessoryById(Long id) {
        return accessoryRepository.findById(id);
    }

    @Override
    public void save(Accessory accessory) {
        accessoryRepository.save(accessory);
    }

    @Override
    public void deleteById(Long id) {
        accessoryRepository.deleteById(id);
    }
}
