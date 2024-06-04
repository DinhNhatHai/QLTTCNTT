package com.EquipMgmt.EquipMgmtspringboot.Services;

import com.EquipMgmt.EquipMgmtspringboot.Models.SubCategory;
import com.EquipMgmt.EquipMgmtspringboot.Repository.SubCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SubCategoryServiceImpl implements SubCategoryService {

    @Autowired
    private SubCategoryRepository subCategoryRepository;

    @Override
    public List<SubCategory> findAll() {
        return subCategoryRepository.findAll();
    }

    @Override
    public Optional<SubCategory> getSubCategoryById(Long id) {
        return subCategoryRepository.findById(id);
    }

    @Override
    public void save(SubCategory subCategory) {
        subCategoryRepository.save(subCategory);
    }

    @Override
    public void deleteById(Long id) {
        subCategoryRepository.deleteById(id);
    }

    @Override
    public List<SubCategory> search(String keyword) {
        return subCategoryRepository.searchSubCategory(keyword);
    }
}
