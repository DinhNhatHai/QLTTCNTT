package com.EquipMgmt.EquipMgmtspringboot.Repository;


import com.EquipMgmt.EquipMgmtspringboot.Models.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
    @Query("SELECT b FROM Category b WHERE b.nameCategory LIKE %?1%")
    List<Category> searchCategory(String keyword);

}
