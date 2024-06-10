package com.EquipMgmt.EquipMgmtspringboot.Services;

import com.EquipMgmt.EquipMgmtspringboot.Models.Storage;
import java.util.List;

public interface StorageService {
    List<Storage> getAllStorages();
    Storage getStorageById(Long id);
    Storage saveStorage(Storage storage);
    void deleteStorage(Long id);
    List<Storage> searchStorages(String name);
}
