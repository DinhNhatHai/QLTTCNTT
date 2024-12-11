package com.EquipMgmt.EquipMgmtspringboot.Repository;


import com.EquipMgmt.EquipMgmtspringboot.Models.EquipmentType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EquipmentTypeRepository extends JpaRepository<EquipmentType, Long> {
}
