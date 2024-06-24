package com.EquipMgmt.EquipMgmtspringboot.Services;

import com.EquipMgmt.EquipMgmtspringboot.Models.Category;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface CategoryService {
    List<Category> getAll();
    Boolean create(Category category);
    Optional<Category> findById(Long id);
    Boolean update(Category category);
    Boolean delete(Long id);
    List<Category> search(String keyword);
}
