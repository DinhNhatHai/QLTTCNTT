package com.EquipMgmt.EquipMgmtspringboot.Services;

import com.EquipMgmt.EquipMgmtspringboot.Models.SubCategory;
import com.EquipMgmt.EquipMgmtspringboot.Repository.SubCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubCategoryServiceImpl implements SubCategoryService {
    @Autowired
    private SubCategoryRepository subCategoryRepository;
    @Override
    public List<SubCategory> getAll() {
        return this.subCategoryRepository.findAll();
    }

    @Override
    public Boolean create(SubCategory subCategory) {
        try {
            this.subCategoryRepository.save(subCategory);
        }catch (Exception e){
            e.printStackTrace();
        }
        return false ;
    }

    @Override
    public SubCategory findById(Long id) {
        return this.subCategoryRepository.findById(id).get();
    }

    @Override
    public Boolean update(SubCategory subCategory) {
        try{
            this.subCategoryRepository.save(subCategory);
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public Boolean delete(Long id) {
        try{
            this.subCategoryRepository.deleteById(id);
        }catch(Exception e){
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public List<SubCategory> search(String keyword) {
        return subCategoryRepository.searchSubCategory(keyword);
    }
}
