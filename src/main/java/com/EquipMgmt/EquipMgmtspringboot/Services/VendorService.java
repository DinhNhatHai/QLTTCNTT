package com.EquipMgmt.EquipMgmtspringboot.Services;

import com.EquipMgmt.EquipMgmtspringboot.Models.Vendor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public interface VendorService {
    List<Vendor> findAll();
    Optional<Vendor> getVendorById(Long id);
    void save(Vendor vendor);
    void deleteById(Long id);
}
