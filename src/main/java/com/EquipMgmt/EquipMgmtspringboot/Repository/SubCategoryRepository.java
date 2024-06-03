package com.EquipMgmt.EquipMgmtspringboot.Repository;

import com.EquipMgmt.EquipMgmtspringboot.Models.SubCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SubCategoryRepository extends JpaRepository<SubCategory, Long> {
    @Query("SELECT b FROM SubCategory b WHERE b.nameSubCategory LIKE %?1%")
    List<SubCategory> searchSubCategory(String keyword);
}

