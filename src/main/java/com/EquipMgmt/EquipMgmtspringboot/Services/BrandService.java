package com.EquipMgmt.EquipMgmtspringboot.Services;

import com.EquipMgmt.EquipMgmtspringboot.Models.Brand;
import com.EquipMgmt.EquipMgmtspringboot.Models.Employee;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public interface BrandService {
    List<Brand> findAll();
    Optional<Brand> getBrandById(Long id);
    void save(Brand brand);
    void deleteById(Long id);
}