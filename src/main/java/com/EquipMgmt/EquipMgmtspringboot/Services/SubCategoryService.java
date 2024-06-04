package com.EquipMgmt.EquipMgmtspringboot.Services;

import com.EquipMgmt.EquipMgmtspringboot.Models.SubCategory;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public interface SubCategoryService {
    List<SubCategory> getAll();
    Boolean create(SubCategory subCategory);
    SubCategory findById(Long id);
    Boolean update(SubCategory subCategory);
    Boolean delete(Long id);
    List<SubCategory> search(String keyword);
}