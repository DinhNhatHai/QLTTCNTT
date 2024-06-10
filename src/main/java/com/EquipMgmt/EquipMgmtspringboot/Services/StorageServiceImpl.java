package com.EquipMgmt.EquipMgmtspringboot.Services;

import com.EquipMgmt.EquipMgmtspringboot.Models.Storage;
import com.EquipMgmt.EquipMgmtspringboot.Repository.StorageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StorageServiceImpl implements StorageService {

    @Autowired
    private StorageRepository storageRepository;

    @Override
    public List<Storage> getAllStorages() {
        return storageRepository.findAll();
    }

    @Override
    public Storage getStorageById(Long id) {
        return storageRepository.findById(id).orElse(null);
    }

    @Override
    public Storage saveStorage(Storage storage) {
        return storageRepository.save(storage);
    }

    @Override
    public void deleteStorage(Long id) {
        storageRepository.deleteById(id);
    }

    @Override
    public List<Storage> searchStorages(String name) {
        return storageRepository.findByStorageNameContaining(name);
    }
}
