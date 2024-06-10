package com.EquipMgmt.EquipMgmtspringboot.Repository;

import com.EquipMgmt.EquipMgmtspringboot.Models.Brand;
import com.EquipMgmt.EquipMgmtspringboot.Models.DepartmentType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DepartmentTypeRepository extends JpaRepository<DepartmentType, Long> {

}
