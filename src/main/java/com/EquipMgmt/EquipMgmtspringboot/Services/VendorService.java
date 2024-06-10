package com.EquipMgmt.EquipMgmtspringboot.Services;

import com.EquipMgmt.EquipMgmtspringboot.Models.Vendor;

import java.util.List;
import java.util.Optional;

public interface VendorService {
    List<Vendor> findAll();
    Optional<Vendor> getVendorById(Long id);
    void save(Vendor vendor);
    void deleteById(Long id);
    List<Vendor> searchVendorsByName(String name);
}
