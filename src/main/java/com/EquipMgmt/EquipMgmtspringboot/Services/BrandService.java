package com.EquipMgmt.EquipMgmtspringboot.Services;

import com.EquipMgmt.EquipMgmtspringboot.Models.Brand;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public interface BrandService {
    List<Brand> getAllBrands();
    Brand getBrandById(Long id);
    Brand createBrand(Brand brand);
    Brand updateBrand(Long id, Brand brand);
    void deleteBrand(Long id);
}