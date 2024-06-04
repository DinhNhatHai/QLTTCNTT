package com.EquipMgmt.EquipMgmtspringboot.Services;

import com.EquipMgmt.EquipMgmtspringboot.Models.Category;
import com.EquipMgmt.EquipMgmtspringboot.Repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService{
    @Autowired
    private CategoryRepository categoryRepository;
    @Override
    public List<Category> getAll() {
        return this.categoryRepository.findAll();
    }

    @Override
    public Boolean create(Category category) {
        try {
            this.categoryRepository.save(category);
        }catch (Exception e){
            e.printStackTrace();
        }
        return false ;
    }

    @Override
    public Category findById(Long id) {
        return this.categoryRepository.findById(id).get();

    }

    @Override
    public Boolean update(Category category) {

        try {
            this.categoryRepository.save(category);
        }catch (Exception e){
            e.printStackTrace();
        }
        return false ;
    }

    @Override
    public Boolean delete(Long id) {
        try{
             this.categoryRepository.delete(findById(id));
             return true;
        }catch(Exception e){
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public List<Category> search(String keyword) {
        return categoryRepository.searchCategory(keyword);
    }


}
