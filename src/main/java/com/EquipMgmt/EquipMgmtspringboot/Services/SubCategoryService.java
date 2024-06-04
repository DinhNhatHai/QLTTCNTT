package com.EquipMgmt.EquipMgmtspringboot.Services;

import com.EquipMgmt.EquipMgmtspringboot.Models.SubCategory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public interface SubCategoryService {
    List<SubCategory> findAll();
    Optional<SubCategory> getSubCategoryById(Long id);
    void save(SubCategory subCategory);
    void deleteById(Long id);
    List<SubCategory> search(String keyword);
}